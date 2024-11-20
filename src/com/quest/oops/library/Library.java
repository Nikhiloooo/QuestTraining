package com.quest.oops.library;

public class Library extends LibrarySystem{
    private Book[] books;
    private LibraryMember[] members;
    private int bookCount = 0;
    private int memberCount = 0;
    private final int maxBooks=10;
    private final int maxMembers=10;

    public Library() {
        books = new Book[maxBooks];
        members = new LibraryMember[maxMembers];
    }


    @Override
    public boolean addBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (bookCount < maxBooks  && !books[i].isAvailable()) {
                books[bookCount] = book;
                bookCount++;
                return true;
             }
        }
        System.out.println("book aldready found");
        return false;
    }


   @Override
    public boolean addMember(LibraryMember member) {

           if (memberCount < maxMembers ) {
               members[memberCount] = member;
               memberCount++;
               return true;
           }

        return false;
    }


@Override
    public boolean searchBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }



    @Override
    public boolean borrowBook(String memberId, String isbn) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                for (int j = 0; j < bookCount; j++) {
                    if (books[j].getIsbn().equals(isbn) && books[j].isAvailable()) {
                        books[j].setAvailabilityStatus(false);
                        System.out.println("Book borrowed successfully by " + members[i].getName());
                        return true;
                    }
                }
            }
        }
        System.out.println("Book borrowing failed. Either the book is unavailable or member not found.");
        return false;
    }


    @Override
    public boolean returnBook(String memberId, String isbn) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                for (int j = 0; j < bookCount; j++) {
                    if (books[j].getIsbn().equals(isbn) && !books[j].isAvailable()) {
                        books[j].setAvailabilityStatus(true);
                        System.out.println("Book returned successfully by " + members[i].getName());
                        return true;
                    }
                }
            }
        }
        System.out.println("Book return failed. Either the book was not borrowed or the member is invalid.");
        return false;
    }



@Override
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                System.out.println("ISBN: " + books[i].getIsbn() + ", Title: " + books[i].getTitle());
            }
        }
    }




@Override
    public void displayAllMembers() {
        System.out.println("Library Members:");
        for (int i = 0; i < memberCount; i++) {
            System.out.println("Member ID: " + members[i].getMemberId() + ", Name: " + members[i].getName());
        }
    }
}
