package com.quest.casestudies.AutomobileManagementSystem;

import java.time.LocalDate;

public class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String vehicleId, String brand, String model, double price, LocalDate manufactureDate, int seatingCapacity) {
        super(vehicleId, brand, model, price, manufactureDate);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", seatingCapacity=" + seatingCapacity + '}';
    }
}

