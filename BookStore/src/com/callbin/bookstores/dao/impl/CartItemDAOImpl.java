package com.callbin.bookstores.dao.impl;

import com.callbin.bookstores.dao.CartItemDAO;
import com.callbin.bookstores.pojo.CartItem;
import com.callbin.bookstores.pojo.User;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/12 18:15
 */
public class CartItemDAOImpl extends BasicDAO implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        System.out.println(cartItem.getUserBean().getClass());
        update("insert into t_cart_item values(null,?,?,?)",
                cartItem.getBookId(),cartItem.getBuyCount(),cartItem.getUserBean());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        update("update t_cart_item set buyCount = ? where id = ?",cartItem.getBuyCount(),cartItem.getId());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        return queryMulti("select * from t_cart_item where userBean = ? ",CartItem.class,user.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        update("delete from t_cart_item where id = ?",cartItem.getId());
    }
}
