package com.quest.exception_handiling.custom_exception;

public class Person {
    int age;
    String name;

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age>18)
        {
            throw new InvalidAgeException(age,"not valid age to vote");
        }
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
