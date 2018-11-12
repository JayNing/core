package com.jay.demo.design.prototype;

/**
 * @Author JAY
 * @Date 2018/11/11 10:01
 * @Description 书籍
 **/
public class Book implements Cloneable{

    private String name;

    private Author author;

    public Book clone(){
        Book book = null;
        try {
            book = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
