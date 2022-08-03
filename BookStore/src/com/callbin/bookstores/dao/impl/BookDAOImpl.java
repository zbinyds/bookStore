package com.callbin.bookstores.dao.impl;

import com.callbin.bookstores.dao.BookDAO;
import com.callbin.bookstores.pojo.Book;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/12 15:57
 */
public class BookDAOImpl extends BasicDAO implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return queryMulti("select * from t_book",Book.class);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return (Book) querySingle("select * from t_book where id = ?",Book.class,bookId);
    }
}
