package com.callbin.bookstores.service.impl;

import com.callbin.bookstores.dao.BookDAO;
import com.callbin.bookstores.dao.CartItemDAO;
import com.callbin.bookstores.dao.UserDAO;
import com.callbin.bookstores.pojo.Book;
import com.callbin.bookstores.pojo.Cart;
import com.callbin.bookstores.pojo.CartItem;
import com.callbin.bookstores.pojo.User;
import com.callbin.bookstores.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张滨
 * @time 2022/07/12 18:27
 */
public class CartItemServiceImpl implements CartItemService {
    private CartItemDAO cartItemDAO;
    private BookDAO bookDAO;
    private UserDAO userDAO;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        // 判断当前用户的购物车中是否有这本图书的CartItem，有--> addCartItem，没有--> updateCartItem。
        // 1.如果我的购物车中已经存在这本图书，则购物车中图书数量+1
        // 2.如果我的购物车中不存在这本图书，则新增一个这本图书的cartItem，数量为1
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<>();
            }

            if (cartItemMap.containsKey(cartItem.getBook().getId())) {
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                updateCartItem(cartItemTemp);
            } else {
                addCartItem(cartItem);
            }
        }else {
            addCartItem(cartItem);
        }
    }

    @Override
    public Cart getCartByUser(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);

        // 根据购物车项获取购物车
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            // 由于pojo中无法进行外键关联，不得已需要借助新的属性来进行pojo连接
            User userTemp = userDAO.getUserById(cartItem.getUserBean());
            cartItem.setUser(userTemp);
            Book book = bookDAO.getBookById(cartItem.getBookId());
            cartItem.setBook(book);
            cartItem.getXj();

            cartItemMap.put(book.getId(),cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);

        return cart;
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        cartItemDAO.delCartItem(cartItem);
    }
}
