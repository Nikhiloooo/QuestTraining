package com.quest.collection.list;

import java.util.LinkedList;

public class LinkedListClass {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Aswin");
        list.add("Alex");
        list.add("Rahul");
        list.add("nik");

        list.addFirst("akash");
        list.add(4, "Alice");
        list.addLast("Bahul");

        System.out.println("first element : "+list.getFirst());
        System.out.println("Last element  : "+list.getLast());
        System.out.println("element at 1st index : "+list.get(1));
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list.remove(2));
        System.out.println(list.size());

//        list.clear();

        System.out.println("----------------------");
        for (String s : list) {
            System.out.println(s);
        }

        Person1 person=new Person1("nikh", 23, "male", "kerala");
        System.out.println("---------------------");
        LinkedList<String> list2 = new LinkedList<>();
        System.out.println(list.isEmpty());
        System.out.println(list.contains("akash"));
        list.remove(person);
    }
}
