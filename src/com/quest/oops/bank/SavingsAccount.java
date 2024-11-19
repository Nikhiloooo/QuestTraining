package com.quest.oops.bank;

public class SavingsAccount extends BankAccount {

    private static final double MIN_BALANCE = 500.0;

    @Override
    public void setBalance(double balance) {
        if (balance >= MIN_BALANCE) {
            super.setBalance(balance);
        } else {
            System.out.println("Cannot set balance below minimum balance (" + MIN_BALANCE + ").");
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Savings Account");
        System.out.println("Minimum Balance: " + MIN_BALANCE);
    }
}
