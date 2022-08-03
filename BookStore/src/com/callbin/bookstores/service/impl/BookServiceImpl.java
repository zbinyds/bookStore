package com.callbin.bookstores.service.impl;

import com.callbin.bookstores.dao.BookDAO;
import com.callbin.bookstores.pojo.Book;
import com.callbin.bookstores.service.BookService;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/12 16:00
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }
}
