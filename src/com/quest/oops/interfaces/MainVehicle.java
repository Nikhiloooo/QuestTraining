package com.quest.oops.interfaces;

public class MainVehicle {
    public static void main(String[] args) {
        Vehicle b1=new Bike();
        b1.wheel();
        b1.horn();
        Vehicle c1=new Car();
        c1.wheel();
        c1.horn();
        Vehicle2 b2=new Car();
        b2.engine();
        b2.lights();


    }
}
