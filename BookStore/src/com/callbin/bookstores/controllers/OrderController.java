package com.callbin.bookstores.controllers;

import com.callbin.bookstores.pojo.OrderBean;
import com.callbin.bookstores.pojo.OrderItem;
import com.callbin.bookstores.pojo.User;
import com.callbin.bookstores.service.OrderBeanService;
import com.callbin.bookstores.service.OrderItemService;
import com.callbin.bookstores.service.UserService;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 张滨
 * @time 2022/07/13 12:44
 */
public class OrderController {
    private OrderBeanService orderBeanService;

    public String checkOut(HttpSession session) {
        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        // 订单编号
        String orderNo = UUID.randomUUID().toString() + "_" + now.getYear() + now.getMonth()+1 + now.getDate() + now.getHours() + now.getMinutes() + now.getSeconds();
        orderBean.setOrderNo(orderNo);
        // 订单日期
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        orderBean.setOrderDate(timestamp);
        // 订单总金额
        User user = (User) session.getAttribute("user"); // 当前登录用户
        Double totalMoney = user.getCart().getTotalMoney();
        orderBean.setOrderMoney(totalMoney);
        // 订单状态
        orderBean.setOrderStatus(0);
        // 订单所属用户id
        orderBean.setOrderUser(user.getId());

        orderBeanService.addOrderBean(orderBean);

        return "redirect:book.do?operate=getBookList";
    }

    public String getOrderList(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<OrderBean> orderBeanList = orderBeanService.getOrderBeanList(user);
        user.setOrderBeanList(orderBeanList);

        return "order/order";
    }
}
