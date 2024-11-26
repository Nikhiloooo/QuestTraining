package com.quest.bookstore;

public class Book {
    private String title;
    private String author;
    private double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
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
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }



    public void purchase(int quantity) throws OutOfStockException {
        if (stock < quantity) {
            throw new OutOfStockException("Insufficient stock for book: " + title);
        }
        stock -= quantity;
        System.out.println(quantity + " copies of " + title + " purchased successfully!");
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", Price=" + price + ", Stock=" + stock + "]";
    }
}
