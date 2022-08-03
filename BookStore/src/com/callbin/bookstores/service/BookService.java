package com.callbin.bookstores.service;

import com.callbin.bookstores.pojo.Book;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/12 15:59
 */
public interface BookService {
    // 获取所有图书信息
    List<Book> getBookList();
}
