package com.quest.oops.abstraction;

public class OnlineStudent  extends Student {

     public OnlineStudent()
     {
         System.out.println("creating online student");
     }

    @Override
    public void attendClass() {
        System.out.println("online student Attending Class");
    }

    @Override
    public void submitAssignment() {
        System.out.println("online student Submit Assignment");
    }
}
