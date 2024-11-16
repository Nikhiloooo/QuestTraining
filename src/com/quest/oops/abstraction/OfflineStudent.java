package com.quest.oops.abstraction;

public class OfflineStudent extends Student {
    @Override
    public void attendClass() {
        System.out.println(" offline student attending class");
    }

    @Override
    public void submitAssignment() {
        System.out.println(" offline student submit assignment");
    }
}
