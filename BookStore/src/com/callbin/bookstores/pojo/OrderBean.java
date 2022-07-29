package com.callbin.bookstores.pojo;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/12 14:06
 */
public class OrderBean {
    private Integer id; // 订单id
    private String orderNo; // 订单编号
    private Timestamp orderDate; // 订单日期
    private Double orderMoney; // 订单总金额
    private Integer orderStatus; // 订单状态
    private Integer orderUser; // 所属用户Id

    private User user; // 所属用户实体
    private List<OrderItem> orderItemList; // 订单详情（包含订单内各个图书的相关信息）
    private Integer totalBookCount; // 订单图书总数量

    public OrderBean() {
    }

    public Integer getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", orderDate=" + orderDate +
                ", orderMoney=" + orderMoney +
                ", orderStatus=" + orderStatus +
                ", orderUser=" + orderUser +
                ", user=" + user +
                ", orderItemList=" + orderItemList +
                '}';
    }
}
