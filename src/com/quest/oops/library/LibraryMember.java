package com.quest.oops.library;

public class LibraryMember {
    private String memberId;
    private String name;
    private String contactInfo;
    private String[] borrowedBooks;
    private int borrowedCount;
    private int maxBooks;

    public LibraryMember() {
        maxBooks = 5;
        borrowedBooks = new String[maxBooks];
    }


    public String getMemberId() {
        return memberId;
    }


    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getContactInfo() {
        return contactInfo;
    }


    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }


    public boolean borrowBook(String isbn) {
        for (int i = 0; i < maxBooks; i++) {
            if (borrowedBooks[i] == null) {
                borrowedBooks[i] = isbn;
                return true;
            }
        }
        return false;
    }


    public boolean returnBook(String isbn) {
        for (int i = 0; i < maxBooks; i++) {
            if (borrowedBooks[i] != null && borrowedBooks[i].equals(isbn)) {
                borrowedBooks[i] = null;
                return true;
            }
        }
        return false;
    }


    public String[] getBorrowedBooks() {
        return borrowedBooks;
    }

}
