package com.zx.entity;

import java.time.LocalDate;

/**
 * 书的实体类
 *
 * @author ning
 * @create 2018-06-12 9:22
 **/
public class Book {
    private Integer id;
    private String name;
    private Double price;
    private String type;
    private LocalDate publishDate;

    public Book(Integer id, String name, Double price, String type, LocalDate publishDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", type=" + type +
                ", publishDate=" + publishDate +
                '}';
    }
}