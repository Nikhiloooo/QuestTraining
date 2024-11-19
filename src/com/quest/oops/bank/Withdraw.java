package com.quest.oops.bank;

public class Withdraw extends Transaction {

    public Withdraw(BankAccount account) {
        super(account);
    }

    @Override
    public void processTransaction(double amount) {
        if (amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }

    }
}
