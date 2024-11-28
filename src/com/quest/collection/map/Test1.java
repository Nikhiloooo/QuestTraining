package com.quest.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Test1 {
    public static void main(String[] args) {
        HashMap<Integer,String> h=new HashMap<Integer,String>();
        TreeMap<Integer,String> t=new TreeMap<>();
        h.put(1,"A");
        h.put(3,"C");
        h.put(4,"D");
        h.put(2,"B");

        t.put(1,"C");
        t.put(3,"C");
        t.put(4,"D");
        t.put(2,"B");


//        h.forEach((k, v) -> System.out.println(k + " : " + v));
//        System.out.println();
//        t.forEach((k, v) -> System.out.println(k + " : " + v));

        HashMap<String,String> h1=new HashMap<String,String>();
        TreeMap<String,String> t1=new TreeMap<>();

        h1.put("A","A");
        h1.put("D","D");
        h1.put("C","C");
        h1.put("B","B");
        h1.put(null,"T");




        t1.put("A","A");
        t1.put("D","D");
        t1.put("C","C");
        t1.put("B","B");
        t1.put("E",null);

//        h1.forEach((k, v) -> System.out.println(k + " : " + v));
//        System.out.println();
//        t1.forEach((k, v) -> System.out.println(k + " : " + v));


        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"A");
        linkedHashMap.put(3,"C");
        linkedHashMap.put(4,"D");
        linkedHashMap.put(2,"B");
        linkedHashMap.put(5,null);
        linkedHashMap.put(6,null);
        linkedHashMap.put(7,null);
        linkedHashMap.forEach((k, v) -> System.out.println(k + " : " + v));


    }
}
