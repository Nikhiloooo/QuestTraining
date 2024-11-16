package com.quest.oops.inheritance;

public class Dog extends Animal {
    private String breed;

    public Dog(String species,String size, String breed) {
        super(species,size);
        this.breed = breed;
    }

    public void bark(){
        System.out.println(breed +" is barking");
    }

    @Override
    public void sound() {
        super.sound();
        System.out.println(breed +" is making sound");
    }
}
