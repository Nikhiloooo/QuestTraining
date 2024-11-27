package com.quest.java8.librarymanagement;



import java.util.List;

public interface Library {

    boolean addBook(Book book);
    boolean borrowBook(String bookId, Student requestedBy);
    boolean returnBook(String bookId, Student requestedBy) throws CloneNotSupportedException;
    List<Book> availableBooks();
    List<BorrowRecord> borrowedHistory();
}
