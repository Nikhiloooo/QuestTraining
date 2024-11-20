package com.quest.oops.abstraction;

public class AnimalExample {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Snake();
        animals[2] = new Bird();

        int i=0;
        while(i<animals.length) {
            animals[i].makeSound();
            animals[i].move();
            animals[i].eat();
            System.out.println();
            i++;
        }
    }


}
