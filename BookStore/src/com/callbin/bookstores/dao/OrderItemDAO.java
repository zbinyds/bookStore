package com.callbin.bookstores.dao;

import com.callbin.bookstores.pojo.OrderItem;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/13 11:04
 */
public interface OrderItemDAO {
    // 订单详情表新增一条记录
    void addOrderItem(OrderItem orderItem);

    // 根据订单编号查询 该订单详情信息
    List<OrderItem> getOrderItemListById(Integer id);

    // 获取订单详情表中每个订单的图书总数量
    Integer getOrderBookTotalCount(Integer orderId);
}
