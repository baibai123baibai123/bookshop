package com.baibin.service;

import com.baibin.pojo.Book;
import com.baibin.pojo.Page;

import java.util.List;

/**
 * @Author: Baibin
 * @Date: 2022/4/23 4:37
 * @Description: TODO
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
