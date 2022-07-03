package com.baibin.web;

import com.baibin.pojo.Book;
import com.baibin.pojo.Cart;
import com.baibin.pojo.CartItem;
import com.baibin.service.BookService;
import com.baibin.service.impl.BookServiceImpl;
import com.baibin.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Baibin
 * @Date: 2022/5/9 22:57
 * @Description: TODO
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookservice.queryboobyid得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息转化为cartitem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用cart.additem添加商品
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",cartItem.getName());
        //重定向回商品页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //根据id删除
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            //重定向回购物车页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);

        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
