package com.baibin.web;

import com.baibin.pojo.Book;
import com.baibin.pojo.Page;
import com.baibin.service.BookService;
import com.baibin.service.impl.BookServiceImpl;
import com.baibin.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Baibin
 * @Date: 2022/4/23 4:48
 * @Description: TODO
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取最后的页码添加完成后跳转到最后一页，加一是为了利用数据边界有效 超出总页码数也跳转到最后一页
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;
        //获取请求参数并封装成javabean对象
        Book book = WebUtils.copyParmToBean(req.getParameterMap(), new Book());
        //添加图书
        bookService.addBook(book);
        //添加成功后跳转到图书列表页面
        // 3。请求重定向到(工程名/manager/book_manager.jsp页面  重定向/代表到端口号(.....localhost:8080/)
//                转发中/代表到工程名（.....bookshop002/)
        //这里不能用转发是因为有bug，浏览器会记录最后一次请求的全部信息，导致按F5刷新时会再次请求导致重复添加，所有用重定向
//        因为转发是一次请求，重定向是两次请求（第一次是添加页面，第二次就是list列表页面了）
//        req.getRequestDispatcher("/pages/manager/bookServlet?action=list").forward(req, resp);
//        System.out.println(req.getContextPath());  输出  /bookshop002  /代表 (http://主机名：端口号/)
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book = WebUtils.copyParmToBean(req.getParameterMap(), new Book());
//        bookService.deleteBookById(book.getId());
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取提交的参数信息并封装成javabean对象
        Book book = WebUtils.copyParmToBean(req.getParameterMap(), new Book());
        //添加到数据库中
        bookService.updateBook(book);
        //重定向到list页面（转发会有F5刷新bug） 分页功能完成后跳到page
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的图书编号
//        int i = WebUtils.parseInt(req.getParameter("id"), 0);
        //通过id查询图书信息
        String id = req.getParameter("id");
        Integer i = Integer.parseInt(id);
        Book book = bookService.queryBookById(i);
        req.setAttribute("book", book);//值不用加引号，找了一下午bug因为加了引号页面空白显示
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过bookservice查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把图书全部保存到request域中
        req.setAttribute("books", books);
        // 3。请求转发到manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //处理分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数当前页数pageNo和显示条数pagesize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookservice.page(pageNo,pageSize)方法返回page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //将page对象保存在request域中
        req.setAttribute("page", page);
        //请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

}
