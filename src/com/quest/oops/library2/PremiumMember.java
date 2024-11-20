package com.quest.oops.library2;

public class PremiumMember extends Member {
    private int EXTRA_BORROW_LIMIT=2;
    public PremiumMember(String name, int memberId) {
        super(name, memberId, "Premium");
    }
    @Override
    public void borrowBook(Book book) {

        if (borrowedCount < MAX_BORROW_LIMIT + EXTRA_BORROW_LIMIT) {
            borrowedBooks[borrowedCount++] = book;
            System.out.println(getName() + " (Premium) borrowed: " + book);
        } else {
            System.out.println(getName() + " has reached the premium borrowing limit!");
        }
    }
    @Override
    public String toString() {
        return super.toString() + ", Extra Borrow Limit: " + EXTRA_BORROW_LIMIT;
    }

}
