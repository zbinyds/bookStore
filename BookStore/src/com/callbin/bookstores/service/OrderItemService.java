package com.callbin.bookstores.service;

import com.callbin.bookstores.pojo.OrderBean;
import com.callbin.bookstores.pojo.OrderItem;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/13 17:23
 */
public interface OrderItemService {
    // 根据订单编号查询该订单的详细信息
    List<OrderItem> getOrderItemListById(Integer OrderId);

    // 获取订单详情表中每个订单的图书总数量
    Integer getOrderBookTotalCount(Integer orderId);
}
