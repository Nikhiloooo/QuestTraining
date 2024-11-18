package com.quest.oops.interfaces;

public class Car extends Vehicle2 implements Vehicle {

    @Override
    void engine() {
        System.out.println("I'm an car engine");
    }

    @Override
    void lights() {
        System.out.println("I'm an car lights");
    }

    @Override
    public void horn() {
        System.out.println("car Horn");
    }

    @Override
    public void wheel() {
        System.out.println("car Wheel");
    }
}
