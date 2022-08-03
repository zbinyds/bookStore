package com.callbin.bookstores.service;

import com.callbin.bookstores.pojo.Cart;
import com.callbin.bookstores.pojo.CartItem;
import com.callbin.bookstores.pojo.User;

/**
 * @author 张滨
 * @time 2022/07/12 18:19
 */
public interface CartItemService {
    // 添加购物车项
    void addCartItem(CartItem cartItem);

    // 修改指定的购物车项
    void updateCartItem(CartItem cartItem);

    // 判断当前用户的购物车中是否有这本图书的CartItem，有--> addCartItem，没有--> updateCartItem。
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    // 根据用户信息，获取他的购物车信息
    Cart getCartByUser(User user);

    // 删除指定的购物车项
    void delCartItem(CartItem cartItem);
}
