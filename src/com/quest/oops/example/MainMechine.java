package com.quest.oops.example;

public class MainMechine {
    public static void main(String[] args) {
        Mechine genericMachine = new Mechine();
        genericMachine.display();

     Mechine specificMachine = new Mechine("Excavator", 2022);
        specificMachine.display();
        System.out.println(specificMachine);

        System.out.println();

    // Child class object using parameterized constructor with four parameters
    Car car = new Car("Sedan", 2023, "Petrol", 18);
        car.display(); // Overridden method
        car.start(); // Interface method
        System.out.println(car);
}}

