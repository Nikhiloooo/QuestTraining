package com.quest.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class DiffDataTypeMap {
    public static void main(String[] args) {
        HashMap<Double, String> hmap1 = new HashMap<>();
        hmap1.put(1.7,"A");
        hmap1.put(3.5,"C");
        hmap1.put(4.4,"D");
        hmap1.put(2.9,"B");

        LinkedHashMap<Double, String> lhmap1 = new LinkedHashMap<>();
        lhmap1.put(1.7,"A");
        lhmap1.put(3.5,"C");
        lhmap1.put(4.4,"D");
        lhmap1.put(2.9,"B");


        TreeMap<Double, String> tmap1 = new TreeMap<>();
        tmap1.put(1.7,"A");
        tmap1.put(3.5,"C");
        tmap1.put(4.4,"D");
        tmap1.put(2.9,"B");

        hmap1.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println();
        lhmap1.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println();
        tmap1.forEach((k, v) -> System.out.println(k + " : " + v));


    }
}
