package com.baibin.test;

import com.baibin.dao.BookDao;
import com.baibin.dao.impl.BookDaoImpl;
import com.baibin.pojo.Book;
import com.baibin.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Baibin
 * @Date: 2022/4/23 4:15
 * @Description: TODO
 */
public class BookDaoTest {
    private BookDao bookDao= new BookDaoImpl();
    @Test
    public void addBook() throws Exception {
        bookDao.addBook(new Book(null,"宁红叶外传","宁红叶",
                new BigDecimal(198),23,675,"/static/img/宁红叶.jpg"));
    }

    @Test
    public void deleteById() throws Exception {
        System.out.println(bookDao.deleteById(21));
    }

    @Test
    public void updateBook() throws Exception {
        bookDao.updateBook(new Book(21,"宁红叶外传","宁红叶",
                new BigDecimal(198),23,675,"/static/img/宁红叶.jpg"));
    }

    @Test
    public void queryBookById() throws Exception {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() throws Exception {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() throws Exception {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() throws Exception{
        System.out.println(bookDao.queryForPageItems(1, 5));
    }

    @Test
    public void queryForPageTotalCountByPrice() throws Exception {
        System.out.println(bookDao.queryForPageTotalCountByPrice(100,999));
    }

    @Test
    public void queryForPageItemsByPrice() throws Exception{
        System.out.println(bookDao.queryForPageItemsByPrice(0,10,10, 30));
    }

}