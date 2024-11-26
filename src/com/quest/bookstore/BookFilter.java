package com.quest.bookstore;

@FunctionalInterface
interface BookFilter {
    boolean test(Book book);
}
