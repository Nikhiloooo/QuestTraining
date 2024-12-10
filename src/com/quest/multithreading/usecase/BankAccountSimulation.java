package com.quest.multithreading.usecase;


class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    synchronized public void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposit " + amount);
        notify();
    }

    synchronized public void withdraw(double amount) {
        System.out.println(Thread.currentThread().getName() + "  is running");
        if (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawal failed due to insufficient balance.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
        } else {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount b1;
    private double amount;

    public WithdrawThread(BankAccount b1, double amount) {
        this.b1 = b1;
        this.amount = amount;

    }

    public void run() {
        b1.withdraw(amount);
    }

}

class DepositThread extends Thread {
    private BankAccount b1;
    private double amount;

    public DepositThread(BankAccount b1, double amount) {
        this.b1 = b1;
        this.amount = amount;
    }

    public void run() {
        b1.deposit(amount);
    }
}


public class BankAccountSimulation {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(10);
        DepositThread t1 = new DepositThread(b1, 100);
        WithdrawThread t2 = new WithdrawThread(b1, 50);
        WithdrawThread t3 = new WithdrawThread(b1, 200);

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
