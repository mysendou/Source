package com.aug.jeff.dto.domain;

import java.util.Date;

public class Book {

    private String author;
    private float price;
    private Date calendar;
    private Integer id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCalendar() {
        return calendar;
    }

    public void setCalendar(Date calendar) {
        this.calendar = calendar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", price=" + price + ", calendar=" + calendar + ", id=" + id + "]";
    }

}
