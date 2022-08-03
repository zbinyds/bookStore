package com.callbin.bookstores.dao;

import com.callbin.bookstores.pojo.CartItem;
import com.callbin.bookstores.pojo.User;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/12 18:13
 */
public interface CartItemDAO {
    // 新增购物车项
    void addCartItem(CartItem cartItem);

    // 修改指定的购物车项
    void updateCartItem(CartItem cartItem);

    // 根据用户查询所有购物车项信息
    List<CartItem> getCartItemList(User user);

    // 删除指定的购物车项信息
    void delCartItem(CartItem cartItem);
}
