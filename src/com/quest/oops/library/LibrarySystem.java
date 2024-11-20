package com.quest.oops.library;

public abstract class LibrarySystem {

    public abstract boolean addBook(Book book);
    public abstract void displayAvailableBooks();
    public abstract boolean addMember(LibraryMember member);
    public abstract void displayAllMembers();
    public abstract boolean searchBook(String isbn);
    public abstract boolean borrowBook(String memberId, String isbn);
    public abstract boolean returnBook(String memberId, String isbn);

}
