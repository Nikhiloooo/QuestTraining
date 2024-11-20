package com.quest.oops.abstraction;

public class Bird extends Animal {

    @Override
    void makeSound() {
        System.out.println("bird makes sound  Tweet Tweet");
    }

    @Override
    void move() {
        System.out.println("bird fly");
    }

    @Override
    void eat() {
        System.out.println("bird eat insects");
    }
}
