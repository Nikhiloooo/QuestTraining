package com.quest.oops.bank;

public class CurrentAccount extends BankAccount{

    private static final double OVERDRAFT_LIMIT = 2000.0;

    @Override
    public void setBalance(double balance) {
        if (balance >= -OVERDRAFT_LIMIT) {
            super.setBalance(balance);
        } else {
            System.out.println("Cannot set balance below overdraft limit (-" + OVERDRAFT_LIMIT + ").");
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Current Account");
        System.out.println("Overdraft Limit: " + OVERDRAFT_LIMIT);
    }


}
