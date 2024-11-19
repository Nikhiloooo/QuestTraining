package com.quest.oops.bank;
import java.util.Scanner;
public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n--- Bank Account Management System ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum1 = sc.next();
                    System.out.print("Enter Account Holder Name: ");
                    String accName1 = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double initBal1 = sc.nextDouble();
                    account = new SavingsAccount();
                    account.setAccountNumber(accNum1);
                    account.setAccountHolderName(accName1);
                    account.setBalance(initBal1);
                    System.out.println("Savings Account Created Successfully!");
                    break;


                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNum2 = sc.next();
                    System.out.print("Enter Account Holder Name: ");
                    String accName2 = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double initBal2 = sc.nextDouble();
                    account = new CurrentAccount();
                    account.setAccountNumber(accNum2);
                    account.setAccountHolderName(accName2);
                    account.setBalance(initBal2);
                    System.out.println("Current Account Created Successfully!");
                    break;


                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        Transaction deposit = new Deposit(account);
                        deposit.processTransaction(depositAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;


                case 4:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        Transaction withdraw = new Withdraw(account);
                        withdraw.processTransaction(withdrawAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;


                case 5:
                    if (account != null) {
                        account.displayDetails();
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;


                case 6:
                    System.out.println("Exiting... Thank you for using the system.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
         }

    }
}
