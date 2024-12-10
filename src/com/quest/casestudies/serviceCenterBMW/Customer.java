package com.quest.casestudies.serviceCenterBMW;

public class Customer {
    private static int count=0;
    private final String customerId;
    private String name;
    private String email;
    private Vehicle vehicle;

    public Customer(String name, String email,Vehicle vehicle) {
        customerId="Customer"+(++count);
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Customer.count = count;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
