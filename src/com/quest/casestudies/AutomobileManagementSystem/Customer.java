package com.quest.casestudies.AutomobileManagementSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Customer implements Serializable {
    private  static String customerId;
    private String name;
    private String email;
    private List<Vehicle> purchasedVehicles;
    private Map<Vehicle, LocalDateTime> purchaseDateTime;

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.purchasedVehicles = new ArrayList<>();
        this.purchaseDateTime = new HashMap<>();
    }

    public void addPurchasedVehicle(Vehicle vehicle) {
        purchasedVehicles.add(vehicle);
        purchaseDateTime.put(vehicle, LocalDateTime.now());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Customer ID: %s, Name: %s, Email: %s\n", customerId, name, email));
        sb.append("Purchased Vehicles:\n");
        for (Vehicle vehicle : purchasedVehicles) {
            sb.append(vehicle).append(", Purchased On: ").append(purchaseDateTime.get(vehicle)).append("\n");
        }
        return sb.toString();
    }
}

