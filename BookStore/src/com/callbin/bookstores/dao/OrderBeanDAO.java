package com.callbin.bookstores.dao;

import com.callbin.bookstores.pojo.OrderBean;
import com.callbin.bookstores.pojo.User;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/13 11:01
 */
public interface OrderBeanDAO {
    // 向表中添加一条订单记录
    void addOrderBean(OrderBean orderBean);

    // 根据用户，查询该用户的订单信息
    List<OrderBean> getOrderBeanList(User user);
}
