package com.callbin.bookstores.service;

import com.callbin.bookstores.pojo.OrderBean;
import com.callbin.bookstores.pojo.User;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/13 11:25
 */
public interface OrderBeanService {
    // 结账功能
    void addOrderBean(OrderBean orderBean);

    // 获取用户的订单信息
    List<OrderBean> getOrderBeanList(User user);
}
