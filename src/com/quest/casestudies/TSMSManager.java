package com.quest.casestudies;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TSMSManager implements Operations {
    private ArrayList<Subscriber> subscribers = new ArrayList<>();
    private ArrayList<CallRecord> callRecords = new ArrayList<>();

    @Override
    public void addSubscriber(Subscriber sub) {
        subscribers.add(sub);
        System.out.println("Subscriber added: " + sub);
    }

    @Override
    public void updateSubscriberBalance(String id, double amount) {
        for (Subscriber sub : subscribers) {
            if (sub instanceof PrepaidSubscriber && sub.getId().equals(id)) {
                ((PrepaidSubscriber) sub).updateBalance(amount);
                System.out.println("Balance updated for Prepaid Subscriber ID: " + id);
                return;
            }
        }
        System.out.println("Subscriber not found or not a Prepaid plan with ID: " + id);
    }

    @Override
    public void listSubscribers() {
        System.out.println("Listing all subscribers:");
        for (Subscriber sub : subscribers) {
            System.out.println(sub);
        }
    }

    @Override
    public void logCallRecord(CallRecord record) {
        callRecords.add(record);
        System.out.println("Call record added: " + record);
    }

    @Override
    public void displayCallHistory(String subscriberId) {
        System.out.println("Call history for Subscriber ID: " + subscriberId);
        for (CallRecord record : callRecords) {
            if (record.getSubscriberId().equals(subscriberId)) {
                System.out.println(record);
            }
        }
    }

    @Override
    public void generateBill(String subscriberId) {
        Subscriber sub = null;

        for (Subscriber subscriber : subscribers) {
            if (subscriber.getId().equals(subscriberId)) {
                sub = subscriber;
                break;
            }
        }

        if (sub instanceof PostpaidSubscriber) {
            double billAmount = 0;
            for (CallRecord record : callRecords) {
                if (record.getSubscriberId().equals(subscriberId)) {
                    switch (record.getCallType()) {
                        case "Local":
                            billAmount += record.getDuration();
                            break;
                        case "STD":
                            billAmount += record.getDuration() * 2;
                            break;
                        case "ISD":
                            billAmount += record.getDuration() * 5;
                            break;
                        default:
                            System.out.println("Unknown call type for record: " + record.getCallType());
                    }
                }
            }


            System.out.println("Total Bill for Postpaid Subscriber ID " + subscriberId + ": ₹" + billAmount);
        } else if (sub == null) {
            System.out.println("Subscriber ID " + subscriberId + " not found.");
        } else {
            System.out.println("Subscriber ID " + subscriberId + " is not a Postpaid subscriber.");
        }
    }


    @Override
    public void saveDataToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(subscribers);
            oos.writeObject(callRecords);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public void loadDataFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            subscribers = (ArrayList<Subscriber>) ois.readObject();
            callRecords = (ArrayList<CallRecord>) ois.readObject();
            System.out.println("Data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }
}

