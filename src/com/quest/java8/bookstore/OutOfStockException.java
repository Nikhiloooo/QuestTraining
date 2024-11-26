package com.quest.java8.bookstore;

public class OutOfStockException extends Exception {

    public OutOfStockException(String message) {
        super(message);
    }
}
