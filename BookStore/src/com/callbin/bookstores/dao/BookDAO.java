package com.callbin.bookstores.dao;

import com.callbin.bookstores.pojo.Book;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/12 15:56
 */
public interface BookDAO {
    // 查询所有图书信息
    List<Book> getBookList();

    // 根据id获取图书信息
    Book getBookById(Integer bookId);
}
