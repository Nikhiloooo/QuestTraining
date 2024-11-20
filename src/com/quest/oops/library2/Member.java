package com.quest.oops.library2;

public class Member implements LibraryOperations {
    private String name;
    private int memberId;
    private String membershipType;
    protected Book[] borrowedBooks;
    protected int borrowedCount;

    public static final int MAX_BORROW_LIMIT = 3;

    public Member(String name, int memberId, String membershipType) {

        this.name = name;
        this.memberId = memberId;
        this.membershipType = membershipType;
        this.borrowedBooks = new Book[MAX_BORROW_LIMIT];
        this.borrowedCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    @Override
    public void borrowBook(Book book) {
        if (borrowedCount < MAX_BORROW_LIMIT) {
            borrowedBooks[borrowedCount++] = book;
            System.out.println(name + " borrowed: " + book);
        } else {
            System.out.println(name + " has reached the borrowing limit!");
        }
    }

    @Override
    public void returnBook(String bookTitle) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i].getTitle().equalsIgnoreCase(bookTitle)) {
                System.out.println(name + " returned: " + borrowedBooks[i]);
                borrowedBooks[i] = borrowedBooks[--borrowedCount]; // Shift last book to the returned slot
                borrowedBooks[borrowedCount] = null;
                return;
            }
        }
        System.out.println(name + " does not have the book: " + bookTitle);
    }


    public double calculateLateFees(final int daysLate) {
        return daysLate * 2.0;
    }

    public String toString() {
        return "Member[ name: " + name + ", memberId: " + memberId + ", membershipType: " + membershipType+"]";
    }
}
