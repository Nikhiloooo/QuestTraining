package com.quest.oops.abstraction;

public class Snake extends Animal {

    @Override
    void makeSound() {
        System.out.println("Snake Hiss Hiss");
    }

    @Override
    void eat() {
        System.out.println("Snake Eats ");
    }

    @Override
    void move() {
        System.out.println("Snake crawls");
    }
}
