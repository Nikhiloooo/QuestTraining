package com.quest.casestudies.telecomsubscriber;

public class PostpaidSubscriber extends Subscriber {

    public PostpaidSubscriber(String id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", Plan=Postpaid";
    }
}
