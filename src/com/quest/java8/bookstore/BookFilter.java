package com.quest.java8.bookstore;

@FunctionalInterface
interface BookFilter {
    boolean test(Book book);
}
