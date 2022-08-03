package com.callbin.bookstores.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * @author 张滨
 * @time 2022/07/12 18:31
 */
public class Cart {
    private Map<Integer, CartItem> cartItemMap; // 购物车中购物项的集合
    private Double totalMoney;  // 购物车总金额
    private Integer totalCount; // 购物车购物项的数量

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            // 利用临时bigdecimal保存数据。防止totalMoney在进行累加时，出现精度问题。
            BigDecimal temp = new BigDecimal(0 + "");
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> entry : entries) {
                CartItem cartItem = entry.getValue();
                BigDecimal count = new BigDecimal(cartItem.getBuyCount() + "");
                BigDecimal price = new BigDecimal(cartItem.getBook().getPrice() + "");
                BigDecimal res = count.multiply(price);
                temp = temp.add(res);
            }
            // 将临时变量获取到的值赋给totalMoney
            totalMoney = temp.doubleValue();
        }
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItemMap=" + cartItemMap +
                ", totalMoney=" + totalMoney +
                ", totalCount=" + totalCount +
                '}';
    }
}
