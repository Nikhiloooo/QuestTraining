package com.quest.casestudies.serviceCenterBMW;

public class ElectricVehicle extends Vehicle {
    private  double batteryCapacity;
    private double rangePerCharge;


    public ElectricVehicle( String brand, String model, int year, double mileage, String ownerName,double batteryCapacity,double rangePerCharge) {
        super(brand, model, year, mileage, ownerName);
        if (batteryCapacity < 0 || rangePerCharge < 0) {
            throw new IllegalArgumentException("Battery capacity and range cannot be negative");
        }
        this.batteryCapacity = batteryCapacity;
        this.rangePerCharge = rangePerCharge;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getRangePerCharge() {
        return rangePerCharge;
    }

    public void setRangePerCharge(double rangePerCharge) {
        this.rangePerCharge = rangePerCharge;
    }

    @Override
    public String toString() {
        return  super.toString()+  "ElectricVehicle{" +
                "batteryCapacity=" + batteryCapacity +
                ", rangePerCharge=" + rangePerCharge +
                '}';
    }
}
