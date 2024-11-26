package com.quest.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMethodsProduct {
    public static void main(String[] args) {

        ArrayList<Product> list1 = new ArrayList<Product>();
        System.out.println("-------------- ArrayList Methods --------------");
        list1.add(new Product("Laptop", 101, 55000.0, 10));
        list1.add(new Product("Smartphone", 102, 15000.0, 25));
        list1.add(new Product("Tablet", 103, 25000.0, 15));
        list1.add(new Product("Headphones", 104, 2000.0, 50));
        list1.add(new Product("Smartwatch", 105, 8000.0, 20));

        list1.add(5,new Product("Monitor", 106, 12000.0, 12));

        System.out.println("--------price less than 10000-------------");
        for(Product p : list1) {
            if(p.getPrice()<10000)
            {
                System.out.println(p.getProductName()+" : "+p.getPrice());
            }
        }
        System.out.println("---------price greater than 10000-------------");
        Iterator<Product> iterator = list1.iterator();
        while(iterator.hasNext()){
            Product p = iterator.next();
            if(p.getPrice()>10000){
                System.out.println(p.getProductName()+" : "+p.getPrice());
            }
        }

        for(Product p : list1) {
            System.out.println(p.getProductName()+" : "+p.getId()+" : "+p.getPrice()+" : "+p.getQuantity());
        }

        System.out.println("size: "+list1.size());
        System.out.println("isEmpty"+list1.isEmpty());
        System.out.println("Product at index 2: " + list1.get(2).getProductName());
        list1.set(3, new Product("Gaming Headphones", 113, 5000.0, 35));
        System.out.println("----updated list------");
        for(Product p : list1) {
            System.out.println(p.getProductName()+" : "+p.getId()+" : "+p.getPrice()+" : "+p.getQuantity());
        }

        list1.remove(4);
        System.out.println("Does List1 contain Tablet " + list1.contains(new Product("Tablet", 103, 25000.0, 15)));
        // list1.clear();
        System.out.println(list1.indexOf("Tablet"));
        System.out.println("Index of 'Smartphone': " + list1.indexOf(new Product("Smartphone", 102, 15000.0, 25)));
        System.out.println("Last index of 'Tablet': " + list1.lastIndexOf(new Product("Tablet", 103, 25000.0, 15)));
        List<Product> sublist = list1.subList(1, 4);
        System.out.println("----sublist---");
        for(Product p : sublist) {
            System.out.println(p.getProductName()+" : "+p.getId()+" : " +p.getPrice()+" : "+p.getQuantity());

        }





        System.out.println("\n------------LinkedList Methods --------------");
        LinkedList<Product> list2 = new LinkedList<Product>();

        list2.add(new Product("Keyboard", 107, 1500.0, 40));
        list2.add(new Product("Mouse", 108, 500.0, 70));
        list2.add(new Product("Speakers", 109, 3000.0, 30));
        list2.add(new Product("Printer", 110, 7000.0, 8));
        list2.add(new Product("Webcam", 111, 2500.0, 18));
        list2.add(new Product("Microphone", 112, 4500.0, 25));

        list2.addFirst(new Product("Scanner", 113, 6000.0, 5));
        list2.addLast(new Product("Headset", 114, 3500.0, 20));
        System.out.println("LinkedList after adding elements:");
        for(Product p : list2) {
            System.out.println(p.getProductName()+" : "+p.getId()+" : " +p.getPrice()+" : "+p.getQuantity());
        }

        System.out.println("--------Quantity less than 20------------");
        for(Product p : list2) {
            if(p.getQuantity()<20)
            {
                System.out.println(p.getProductName()+" : "+p.getQuantity());
            }
        }
        System.out.println("---------Quantity greater than 20------------");
        Iterator<Product> iterator1 = list2.iterator();
        while(iterator1.hasNext()){
            Product p = iterator1.next();
            if(p.getQuantity()>20){
                System.out.println(p.getProductName()+" : "+p.getQuantity());
            }
        }

        System.out.println("First element: " + list2.getFirst());
        System.out.println("Last element: " + list2.getLast());
        System.out.println("Element at index 3: " + list2.get(3));
        list2.removeFirst();
        list2.removeLast();
        list2.remove(2);
        System.out.println("Does LinkedList contain Webcam? " + list2.contains(new Product("Webcam", 111, 2500.0, 18)));
        System.out.println("Index of 'Mouse': " + list2.indexOf(new Product("Mouse", 108, 500.0, 70)));
        System.out.println("Last index of 'Speakers': " + list2.lastIndexOf(new Product("Speakers", 109, 3000.0, 30)));
        list2.clear();

    }
}
