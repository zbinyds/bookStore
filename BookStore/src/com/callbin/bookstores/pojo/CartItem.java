package com.callbin.bookstores.pojo;

import java.math.BigDecimal;

/**
 * @author 张滨
 * @time 2022/07/12 14:19
 */
public class CartItem {
    private Integer id; // 购物车项id
    private Integer bookId; // 图书id
    private Integer buyCount; // 图书数量
    private Integer userBean; // 所属用户Id

    private Book book; // 图书实体
    private User user; // 用户实体
    private Double xj; // 小计

    public CartItem() {
    }

    public CartItem(Integer id) {
        this.id = id;
    }

    public CartItem(Integer id, Integer buyCount) {
        this.id = id;
        this.buyCount = buyCount;
    }

    public CartItem(Integer bookId, Integer buyCount, Integer userId, Book book, User user) {
        this.bookId = bookId;
        this.buyCount = buyCount;
        this.userBean = userId;
        this.book = book;
        this.user = user;
    }

    public Double getXj() {
        BigDecimal bigDecimalPrice = new BigDecimal(book.getPrice() + "");
        BigDecimal bigDecimalCount = new BigDecimal(buyCount+"");
        BigDecimal res = bigDecimalPrice.multiply(bigDecimalCount);
        xj = res.doubleValue();
        return xj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getUserBean() {
        return userBean;
    }

    public void setUserBean(Integer userBean) {
        this.userBean = userBean;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", buyCount=" + buyCount +
                ", userBean=" + userBean +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}
