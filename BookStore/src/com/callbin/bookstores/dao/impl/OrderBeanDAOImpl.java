package com.callbin.bookstores.dao.impl;

import com.callbin.bookstores.dao.OrderBeanDAO;
import com.callbin.bookstores.pojo.Cart;
import com.callbin.bookstores.pojo.OrderBean;
import com.callbin.bookstores.pojo.User;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/13 11:04
 */
public class OrderBeanDAOImpl extends BasicDAO implements OrderBeanDAO {

    @Override
    public void addOrderBean(OrderBean orderBean) {
        int row = update("insert into t_order values(null,?,?,?,?,?)",
                orderBean.getOrderNo(), orderBean.getOrderDate(), orderBean.getOrderMoney(), orderBean.getOrderStatus(), orderBean.getOrderUser());
        // 这里需要判断一下，当row大于0时，表示插入数据成功。那么我们就可以将此时表中最大的id值，设置到orderBean中。因为id是自增长的。
        if (row > 0){
            Integer orderBeanId = (Integer)queryScalar("select max(id) from t_order");
            orderBean.setId(orderBeanId);
        }
    }

    @Override
    public List<OrderBean> getOrderBeanList(User user) {
        return queryMulti("select * from t_order where orderUser = ?",OrderBean.class,user.getId());
    }

}
