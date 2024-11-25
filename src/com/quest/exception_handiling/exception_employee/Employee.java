package com.quest.exception_handiling.exception_employee;

public class Employee {

    private String name;
    private int age;
    private double salary;
    public Employee(String name, int age, double salary)throws InvalidInputException {
        if(age<18){
            throw new InvalidInputException(" age is less than 18 ");
        }
        if(salary<0){
            throw new InvalidInputException(" salary is negative ");
        }
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public double getSalary() {
        return salary;
    }


    public  final void displaydetails() {
        System.out.println("Name: " + name+"\nAge: " + age+"\nSalary: " + salary);
    }

    @Override
    public String toString() {
        return "\nname=" + name + "\nage=" + age + "\nsalary=" + salary ;
    }
}
