package com.baibin.service.impl;

import com.baibin.dao.BookDao;
import com.baibin.dao.impl.BookDaoImpl;
import com.baibin.pojo.Book;
import com.baibin.pojo.Page;
import com.baibin.service.BookService;

import java.util.List;

/**
 * @Author: Baibin
 * @Date: 2022/4/23 4:40
 * @Description: TODO
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {

        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总记录数
        Integer pageTotalCount=bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //设置总共页数
        Integer pageTotal =pageTotalCount/pageSize;
        if ((pageTotalCount%pageSize)>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        //设置当前页码
//        if (pageNo<1){
//            pageNo=1;
//        }
//        if (pageNo>pageTotal){
//            pageNo=pageTotal;
//        }
        page.setPageNo(pageNo);

        //设置显示的内容
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> list = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(list);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总记录数
        Integer pageTotalCount=bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        //设置总共页数
        Integer pageTotal =pageTotalCount/pageSize;
        if ((pageTotalCount%pageSize)>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        //设置当前页码
//        if (pageNo<1){
//            pageNo=1;
//        }
//        if (pageNo>pageTotal){
//            pageNo=pageTotal;
//        }
        page.setPageNo(pageNo);

        //设置显示的内容
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> list = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(list);
        return page;
    }


}
