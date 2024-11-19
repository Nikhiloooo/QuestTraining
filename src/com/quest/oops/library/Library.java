package com.quest.oops.library;

public class Library {
    private Book[] books;
    private LibraryMember[] members;
    private int bookCount = 0;
    private int memberCount = 0;
    private int maxBooks=10;
    private int maxMembers=10;

    public Library() {
        books = new Book[maxBooks];
        members = new LibraryMember[maxMembers];
    }


    public boolean addBook(Book book) {
        if (bookCount < maxBooks) {
            books[bookCount] = book;
            bookCount++;
            return true;
        }
        return false;
    }


    public boolean addMember(LibraryMember member) {
        if (memberCount < maxMembers) {
            members[memberCount] = member;
            memberCount++;
            return true;
        }
        return false;
    }


    public boolean searchBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }


    public boolean borrowBook(String memberId, String isbn) {
        LibraryMember member = findMember(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        Book book = findBook(isbn);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (book.isAvailable()) {
            if (member.borrowBook(isbn)) {
                book.setAvailabilityStatus(false);
                System.out.println(book+" Book borrowed successfully by "+member);
                return true;
            } else {
                System.out.println("Member cannot borrow more books.");
                return false;
            }
        }
        else {
            System.out.println("Book is unavailable.");
            return false;
        }
    }


    public boolean returnBook(String memberId, String isbn) {
        LibraryMember member = findMember(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        Book book = findBook(isbn);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (member.returnBook(isbn)) {
            book.setAvailabilityStatus(true);
            System.out.println(book+" Book returned successfully by "+member);
            return true;
        } else {
            System.out.println("Book was not borrowed by this member.");
            return false;
        }
    }


    private LibraryMember findMember(String memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;
    }


    private Book findBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }


    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                System.out.println("ISBN: " + books[i].getIsbn() + ", Title: " + books[i].getTitle());
            }
        }
    }


    public void displayAllMembers() {
        System.out.println("Library Members:");
        for (int i = 0; i < memberCount; i++) {
            System.out.println("Member ID: " + members[i].getMemberId() + ", Name: " + members[i].getName());
        }
    }
}
