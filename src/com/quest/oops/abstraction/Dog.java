package com.quest.oops.abstraction;

public class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog  barks Bow Bow");
    }

    @Override
    void eat() {
        System.out.println("Dog eats");
    }

    @Override
    void move() {
        System.out.println("Dog walks");
    }
}
