package com.quest.casestudies;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TelecomSubscriberManagementSystem {
    public static void main(String[] args) {
        TSMSManager manager = new TSMSManager();
        Scanner scanner = new Scanner(System.in);
        String choice="";

        manager.loadDataFromFile("TSMSData.dat");

        System.out.println("Welcome to Telecom Subscriber Management System (TSMS)");

        while (!choice.equals("7"))
        {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Subscriber");
            System.out.println("2. Update Prepaid Balance");
            System.out.println("3. List All Subscribers");
            System.out.println("4. Log Call Record");
            System.out.println("5. Display Call History");
            System.out.println("6. Generate Bill for Postpaid Subscriber");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Subscriber ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Plan Type (Prepaid/Postpaid): ");
                    String planType = scanner.nextLine();

                    if (planType.equalsIgnoreCase("Prepaid")) {
                        System.out.print("Enter Initial Balance: ");
                        double balance = Double.parseDouble(scanner.nextLine());
                        manager.addSubscriber(new PrepaidSubscriber(id, name, phoneNumber, balance));
                    }
                    else if (planType.equalsIgnoreCase("Postpaid")) {
                        manager.addSubscriber(new PostpaidSubscriber(id, name, phoneNumber));
                    }
                    else {
                        System.out.println("Invalid Plan Type! Subscriber not added.");
                    }
                    break;

                case "2":
                    System.out.print("Enter Prepaid Subscriber ID: ");
                    String prepaidId = scanner.nextLine();
                    System.out.print("Enter Amount to Add: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    manager.updateSubscriberBalance(prepaidId, amount);
                    break;

                case "3":
                    manager.listSubscribers();
                    break;

                case "4":
                    System.out.print("Enter Subscriber ID: ");
                    String subscriberId = scanner.nextLine();
                    System.out.print("Enter Call Type (Local/STD/ISD): ");
                    String callType = scanner.nextLine();
                    System.out.print("Enter Call Duration (in minutes): ");
                    int duration = Integer.parseInt(scanner.nextLine());
                    manager.logCallRecord(new CallRecord(subscriberId, callType, duration, LocalDateTime.now()));
                    break;

                case "5":
                    System.out.print("Enter Subscriber ID: ");
                    String callHistoryId = scanner.nextLine();
                    manager.displayCallHistory(callHistoryId);
                    break;

                case "6":
                    System.out.print("Enter Postpaid Subscriber ID: ");
                    String postpaidId = scanner.nextLine();
                    manager.generateBill(postpaidId);
                    break;

                case "7":
                    System.out.println("Exiting the system. Saving data...");
                    manager.saveDataToFile("TSMSData.dat");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


    }
}

