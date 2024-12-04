package com.quest.practice;

public class StringImmutable {
    public static void main(String[] args) {
        String s1 = "Nikhil";
        System.out.println(" before concat : "+s1);
        s1.concat("Mohan");
        System.out.println(" after conacat : "+s1);//no change

        String s2=s1.concat("Mohan");
        System.out.println(" after conacat to new : "+s2);
    }
}
