package com.callbin.bookstores.pojo;

/**
 * @author 张滨
 * @time 2022/07/12 14:14
 */
public class OrderItem {
    private Integer Id; // 订单详情id
    private Integer bookId; // 图书id
    private Integer buyCount; // 图书数量
    private Integer orderBeanId; // 所属订单id

    private Book book; // 图书实体
    private OrderBean orderBean; // 所属订单实体

    public OrderItem() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Integer getOrderBeanId() {
        return orderBeanId;
    }

    public void setOrderBeanId(Integer orderBeanId) {
        this.orderBeanId = orderBeanId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "Id=" + Id +
                ", bookId=" + bookId +
                ", buyCount=" + buyCount +
                ", orderBeanId=" + orderBeanId +
                ", book=" + book +
                ", orderBean=" + orderBean +
                '}';
    }
}
