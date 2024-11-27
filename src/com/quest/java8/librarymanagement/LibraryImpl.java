package com.quest.java8.librarymanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibraryImpl implements Library {

    List<Book> availableBooks = new ArrayList<>();
    List<BorrowRecord> borrowRecords = new ArrayList<>();

    @Override
    public boolean addBook(Book book) {
        if(book.isValid()) {
            availableBooks.add(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean borrowBook(String bookId, Student requestedBy) {
        for(Book book : availableBooks) {
            if(book.getBookId().equalsIgnoreCase(bookId)) {
                if(book.isAvailable()) {
                    book.setAvailable(false);
                    BorrowRecord borrowRecord = new BorrowRecord(book, LocalDateTime.now(), null, requestedBy);
                    borrowRecords.add(borrowRecord);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean returnBook(String bookId, Student student) {
        boolean isBookReturnedSuccessfully = false;
        for (Book book : availableBooks) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                book.setAvailable(true);
                isBookReturnedSuccessfully = true;
            }
        }
        if (isBookReturnedSuccessfully) {
            //have to update the borrowRecords record saying book is return at this time
            for (BorrowRecord borrowRecord1 : borrowRecords) {
                if (borrowRecord1.getBook().getBookId().equalsIgnoreCase(bookId)) {
                    borrowRecord1.getBook().setAvailable(true);
                    borrowRecord1.setReturnedAt(LocalDateTime.now());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Book> availableBooks() {
        return availableBooks;
    }

    @Override
    public List<BorrowRecord> borrowedHistory() {
        return borrowRecords;
    }
}
