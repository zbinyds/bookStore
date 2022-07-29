package com.callbin.bookstores.dao.impl;

import com.callbin.bookstores.dao.OrderItemDAO;
import com.callbin.bookstores.pojo.OrderItem;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author 张滨
 * @time 2022/07/13 11:06
 */
public class OrderItemDAOImpl extends BasicDAO implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        update("insert into t_order_item values(null,?,?,?)",
                orderItem.getBookId(),orderItem.getBuyCount(),orderItem.getOrderBeanId());
    }

    @Override
    public List<OrderItem> getOrderItemListById(Integer id) {
        return queryMulti("select * from t_order_item where orderBeanId = ?",OrderItem.class,id);
    }

    @Override
    public Integer getOrderBookTotalCount(Integer orderId) {
        return ((BigDecimal) queryScalar("select sum(buyCount) AS totalBookCount from t_order_item where orderBeanId = ? group by orderBeanId",orderId)).intValue();
    }


}
