package com.quest.casestudies.serviceCenterBMW;

public class Vehicle {
    private static int startin = 0;
    private final String vin;
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private String ownerName;

    public Vehicle(String brand, String model, int year, double mileage, String ownerName) {
        if (mileage < 0) {
            throw new IllegalArgumentException("Invalid  mileage");
        }
        vin="V"+(++startin);
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.ownerName = ownerName;
    }



    public String getVin() {
        return vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", mileage=" + mileage +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
