package com.callbin.bookstores.pojo;

/**
 * @author 张滨
 * @time 2022/07/12 13:51
 */
public class Book {
    private Integer id; // 图书id
    private String bookName; // 书名
    private String author; // 作者
    private Double price; // 价格
    private Integer salCount; // 销量
    private Integer bookCount; // 库存
    private String bookImg; // 图书图片地址
    private Integer bookStatus = 0; // 图书状态(0：正常；-1：无效)

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSalCount() {
        return salCount;
    }

    public void setSalCount(Integer salCount) {
        this.salCount = salCount;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", salCount=" + salCount +
                ", bookCount=" + bookCount +
                ", bookImg='" + bookImg + '\'' +
                ", bookStatus=" + bookStatus +
                '}';
    }
}
