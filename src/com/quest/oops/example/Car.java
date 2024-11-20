package com.quest.oops.example;

public class Car extends Mechine implements Vehicle {

    private String fuelType;
    private int mileage;

    public Car(String model, int year, String fuelType, int mileage) {
        super(model, year);
        this.fuelType = fuelType;
        this.mileage = mileage;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Fuel Type: " + this.fuelType + ", Mileage: " + this.mileage + " km/l");
    }

    @Override
    public void start() {
        System.out.println("Car " + this.model + " starts with a key ignition.");
    }

    @Override
    public String toString() {
        return super.toString() + ", FuelType=" + this.fuelType + ", Mileage=" + this.mileage + " km/l";
    }
}