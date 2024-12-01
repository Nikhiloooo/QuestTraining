package com.quest.casestudies.telecomsubscriber;

import java.io.Serializable;

public class Subscriber implements Serializable {
    private String id;
    private String name;
    private String phoneNumber;

    public Subscriber(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Subscriber[ID=" + id + ", Name=" + name + ", Phone=" + phoneNumber + "]";
    }
}
