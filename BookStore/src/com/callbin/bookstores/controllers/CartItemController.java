package com.callbin.bookstores.controllers;

import com.callbin.bookstores.dao.BookDAO;
import com.callbin.bookstores.pojo.Book;
import com.callbin.bookstores.pojo.Cart;
import com.callbin.bookstores.pojo.CartItem;
import com.callbin.bookstores.pojo.User;
import com.callbin.bookstores.service.BookService;
import com.callbin.bookstores.service.CartItemService;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;

/**
 * @author 张滨
 * @time 2022/07/12 18:06
 */
public class CartItemController {
    private CartItemService cartItemService;

    public String index(HttpSession session) {
        User user = (User) session.getAttribute("user");
        // 获取当前用户的购物车信息
        Cart cart = cartItemService.getCartByUser(user);
        user.setCart(cart);

        return "cart/cart";
    }

    public String addCart(Integer bookId, HttpSession session) {
        // 登录成功返回登录用户信息。包含Chart购物车。
        User user = (User) session.getAttribute("user");
        // 构造一个购物车项。已知bookId、user对象。
        CartItem cartItem = new CartItem(bookId, 1, user.getId(), new Book(bookId), user);
        // 将指定的图书添加到购物车中
        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());

        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId, Integer buyCount) {
        cartItemService.updateCartItem(new CartItem(cartItemId, buyCount));
        return "redirect:cart.do";
    }

    public String cartInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Cart cart = cartItemService.getCartByUser(user);

        cart.getTotalCount();
        cart.getTotalMoney();

        Gson gson = new Gson();
        String cartJsonStr = gson.toJson(cart);

        return "json:" + cartJsonStr;
    }

    public String delCart(Integer cartItemId){
        cartItemService.delCartItem(new CartItem(cartItemId));
        return "redirect:cart.do";
    }
}
