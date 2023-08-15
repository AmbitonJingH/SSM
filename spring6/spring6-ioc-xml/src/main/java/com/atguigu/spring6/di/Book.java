package com.atguigu.spring6.di;
/*
 * @author  AmbitionJingH
 * @date  2023/8/15 21:34
 * @version 1.0
 */

public class Book {
    private String bname;
    private String author;

    public Book(){

    }
    public Book(String bname, String author) {
        this.bname = bname;
        this.author = author;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
