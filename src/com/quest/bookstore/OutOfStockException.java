package com.quest.bookstore;

public class OutOfStockException extends Exception {
private String message;
    public OutOfStockException(String message) {
        super(message);
    }
}
