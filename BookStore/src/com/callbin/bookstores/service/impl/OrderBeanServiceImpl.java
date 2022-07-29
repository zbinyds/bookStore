package com.callbin.bookstores.service.impl;

import com.callbin.bookstores.dao.CartItemDAO;
import com.callbin.bookstores.dao.OrderBeanDAO;
import com.callbin.bookstores.dao.OrderItemDAO;
import com.callbin.bookstores.dao.UserDAO;
import com.callbin.bookstores.pojo.*;
import com.callbin.bookstores.service.CartItemService;
import com.callbin.bookstores.service.OrderBeanService;
import com.callbin.bookstores.service.OrderItemService;
import com.callbin.bookstores.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author 张滨
 * @time 2022/07/13 11:49
 */
public class OrderBeanServiceImpl implements OrderBeanService {
    private UserDAO userDAO;
    private OrderBeanDAO orderBeanDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;
    private CartItemService cartItemService;
    private UserService userService;
    private OrderItemService orderItemService;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        // 结账分三步：
        // 1.订单表先添加一条记录
        orderBeanDAO.addOrderBean(orderBean); // 此时的orderBean中含有id属性
        // 2.订单详情表添加相应的购物车项记录
        User orderUser = userDAO.getUserById(orderBean.getOrderUser()); // 根据所属用户id获取到这个用户
        orderUser.setCart(cartItemService.getCartByUser(orderUser)); // 用户本身是没有购物车的，我们需要手动添加。
        orderBean.setUser(orderUser); // 将获取到的用户设置到该订单中
        Map<Integer, CartItem> cartItemMap = orderUser.getCart().getCartItemMap();
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItemMap.values()) {
            Integer bookId = cartItem.getBookId(); // 从购物车中获取到的购物项相关信息 - bookId
            Integer buyCount = cartItem.getBuyCount(); // 从购物车中获取到的购物项相关信息 - BuyCount
            Book book = cartItem.getBook(); // 从购物车中获取到的购物项相关信息 - Book
            Integer orderBeanId = orderBean.getId(); // 从订单中获取id，关联我们的订单详情表

            OrderItem orderItem = new OrderItem();
            orderItem.setBookId(bookId);
            orderItem.setBuyCount(buyCount);
            orderItem.setBook(book);
            orderItem.setOrderBeanId(orderBeanId);
            orderItem.setOrderBean(orderBean);

            orderItems.add(orderItem);
        }
        orderBean.setOrderItemList(orderItems);

        List<OrderItem> orderItemList = orderBean.getOrderItemList();
        for (OrderItem orderItem : orderItemList) {
            orderItemDAO.addOrderItem(orderItem);
        }

        // 3.购物车项表中相应的记录删除
        Collection<CartItem> cartItemList = orderUser.getCart().getCartItemMap().values(); //用户的购物车中包含了购物项信息
        for (CartItem cartItem : cartItemList) {
            // 遍历依次删除购物项记录
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderBeanList(User user) {
        List<OrderBean> orderBeanList = orderBeanDAO.getOrderBeanList(user);

        for (OrderBean orderBean : orderBeanList) {
            // 获取订单所属用户实体并添加到订单中
            User orderUser = userService.getUserById(orderBean.getOrderUser());
            orderBean.setUser(orderUser);
            // 获取订单的详细信息并添加到订单中
            List<OrderItem> orderItemList = orderItemService.getOrderItemListById(orderBean.getId());
            orderBean.setOrderItemList(orderItemList);
            // 获取订单的总图书数量并添加到订单中
            Integer orderBookTotalCount = orderItemService.getOrderBookTotalCount(orderBean.getId());
            orderBean.setTotalBookCount(orderBookTotalCount);

        }
        return orderBeanList;
    }
}
