package com.quest.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayPerson1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person1> list = new ArrayList<Person1>();

        list.add(new Person1("nikh", 23, "male", "kerala"));
        list.add(new Person1("bibi", 21, "male", "Mumbai"));
        list.add(new Person1("amiga", 19, "female", "kerala"));
        list.add(new Person1("aswin", 14, "male", "Pune"));
        list.add(new Person1("akhila", 21, "female", "Chennai"));
        list.add(new Person1("sherin", 18, "female", "Delhi"));

        list.add(5, new Person1("nikh", 23, "male", "kerala"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.contains(new Person1("nikh", 23, "male", "kerala"));


        System.out.println("--------age less than 20----------");
        for (Person1 person : list) {
            if (person.getAge() <= 20) {
                System.out.println(person.getName() + "  :  " + person.getAge() + "  :  " + person.getGender() + "  :  " + person.getLocation());
            }
        }

        System.out.println("--------age greater than 20----------");
        Iterator<Person1> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person1 person = iterator.next();
            if (person.getAge() > 20) {
                System.out.println(person.getName() + "  :  " + person.getAge() + "  :  " + person.getGender() + "  :  " + person.getLocation());
            }
        }
    }
}
