package com.quest.casestudies.serviceCenterBMW;

import java.util.HashSet;
import java.util.Set;

public class ServiceCentre<T extends Vehicle> {
    private Set<T> servicedVehicle=new HashSet<>();

    public void addServicedVehicle(T vehicle) {
        servicedVehicle.add(vehicle);
    }
    public Set<T> getAllServicedVehicle(){
        return servicedVehicle;
    }
}
