package com.quest.oops.example;

public class Mechine {
    String model;
    int year;

    public Mechine() {
        System.out.println("Default constructor of Machine called.");
    }

    public Mechine(String model, int year) {
        this.model = model;
        this.year = year;
        System.out.println("Parameterized constructor of Machine called.");
    }

    public void display() {
        System.out.println("Machine Model: " + this.model + ", Year: " + this.year);
    }

    @Override
    public String toString() {
        return "Machine[model=" + this.model + ", year=" + this.year + "]";
    }

}
