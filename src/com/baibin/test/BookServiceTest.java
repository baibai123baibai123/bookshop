package com.baibin.test;

import com.baibin.pojo.Book;
import com.baibin.pojo.Page;
import com.baibin.service.BookService;
import com.baibin.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Baibin
 * @Date: 2022/4/23 4:45
 * @Description: TODO
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() throws Exception {
    }

    @Test
    public void deleteBookById() throws Exception {
    }

    @Test
    public void updateBook() throws Exception {
    }

    @Test
    public void queryBookById() throws Exception {
    }

    @Test
    public void queryBooks() throws Exception {
    }

    @Test
    public void page() {
        System.out.println(bookService.page(3, 4));
    }
    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,4,10,100));
    }

}