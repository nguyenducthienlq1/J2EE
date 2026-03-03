package com.example.bt1_ducthien;

import java.util.Scanner;


public class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    public Book() {
    }

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Nhập 1 cuốn sách (sử dụng Scanner).
     */
    public void input(Scanner x) {
        System.out.print("Nhập mã sách: ");
        this.id = Integer.parseInt(x.nextLine());
        System.out.print("Nhập tên sách: ");
        this.title = x.nextLine();
        System.out.print("Nhập Tác giả: ");
        this.author = x.nextLine();
        System.out.print("Nhập Đơn giá: ");
        this.price = Double.parseDouble(x.nextLine());
    }


    public void output() {
        String msg = """
                BOOK: id=%d, title=%s, author=%s, price=%.2f
                """.formatted(id, title, author, price);
        System.out.print(msg);
    }
}
