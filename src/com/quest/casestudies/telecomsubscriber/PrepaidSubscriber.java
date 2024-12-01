package com.quest.casestudies.telecomsubscriber;

public class PrepaidSubscriber extends Subscriber {
    private double balance;

    public PrepaidSubscriber(String id, String name, String phoneNumber, double balance) {
        super(id, name, phoneNumber);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Balance=" + balance + ", Plan=Prepaid";
    }
}
