package com.callbin.bookstores.controllers;

import com.callbin.bookstores.pojo.Book;
import com.callbin.bookstores.pojo.Cart;
import com.callbin.bookstores.pojo.User;
import com.callbin.bookstores.service.BookService;
import com.callbin.bookstores.service.CartItemService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/12 16:08
 */
public class BookController {
    private BookService bookService;
    private CartItemService cartItemService;

    public String getBookList(HttpSession session) {

        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList", bookList);
        return "index";
    }
}
