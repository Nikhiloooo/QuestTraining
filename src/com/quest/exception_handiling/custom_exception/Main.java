package com.quest.exception_handiling.custom_exception;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John");
        person.setAge(12);

        try{
            method1(true);
        }catch(MyFirstCheckedException e){
            System.out.println(e.reason());
            System.out.println("=============");
            e.printStackTrace();
        }

    }
    public static void method1(boolean b) throws MyFirstCheckedException {
        if(b){
            throw new MyFirstCheckedException("test message");
        }
    }
}
