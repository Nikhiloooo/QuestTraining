package com.quest.oops.abstraction;

public class StudentFactory {
    public static Student getStudent(String studentName) {
        if(studentName.equalsIgnoreCase("Online"))
        {
            Student onlineStudent=new OnlineStudent();
            return onlineStudent;
        }else if(studentName.equalsIgnoreCase("Offline")){
            return new OfflineStudent();
        }
        else if(studentName.equalsIgnoreCase("Regular"))
        {
            return new RegularStudent();
        }
        else{
            return null;
        }
    }
}
