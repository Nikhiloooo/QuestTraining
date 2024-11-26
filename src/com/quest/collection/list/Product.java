package com.quest.collection.list;

public class Product {
    private String productName;
    private int id;
    private double price;
    private int quantity;
    public Product(String productName, int id, double price, int quantity) {
        this.productName = productName;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "productName=" + productName + ", id=" + id + ", price=" + price;
    }
}
