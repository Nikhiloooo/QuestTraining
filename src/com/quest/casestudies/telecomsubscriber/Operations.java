package com.quest.casestudies.telecomsubscriber;

public interface Operations {
    void addSubscriber(Subscriber sub);
    void updateSubscriberBalance(String id, double amount);
    void listSubscribers();
    void logCallRecord(CallRecord record);
    void displayCallHistory(String subscriberId);
    void generateBill(String subscriberId);
    void saveDataToFile(String fileName);
    void loadDataFromFile(String fileName);
}

