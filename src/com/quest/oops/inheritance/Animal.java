package com.quest.oops.inheritance;

public class Animal {
    String species;
    String size;

    public Animal(String species, String size) {
        this.species = species;
        this.size = size;
    }

    public void eat()
    {
        System.out.println(species+" is Eating...");
    }

    public void sound()
    {
        System.out.println(species+" is making sound...");
    }


}
