package com.callbin.bookstores.service.impl;

import com.callbin.bookstores.dao.OrderItemDAO;
import com.callbin.bookstores.pojo.OrderItem;
import com.callbin.bookstores.service.OrderItemService;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/13 17:25
 */
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDAO orderItemDAO;

    @Override
    public List<OrderItem> getOrderItemListById(Integer id) {
        return orderItemDAO.getOrderItemListById(id);
    }

    @Override
    public Integer getOrderBookTotalCount(Integer orderId) {
        return orderItemDAO.getOrderBookTotalCount(orderId);
    }
}
