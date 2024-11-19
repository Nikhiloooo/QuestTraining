package com.quest.oops.bank;

public class Deposit extends Transaction {

    public Deposit(BankAccount account) {
        super(account);
    }


    @Override
    public void processTransaction(double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
}
