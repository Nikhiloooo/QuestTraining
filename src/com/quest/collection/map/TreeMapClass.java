package com.quest.collection.map;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.TreeMap;

public class TreeMapClass {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("John", "Wick");
        map.put("Mary", "Alex");
        map.put("Mad", "Max");
        map.put("Don", "Bosco");
        map.put("Arya", "Stark");

        System.out.println(map.keySet());
        System.out.println(map.values());

        map.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println(map.containsKey("Mad"));
        System.out.println(map.containsValue("Stark"));
        map.remove("John");
        map.put("Mary","John");
        map.replace("Don","bosco","Josco");
        map.forEach((k, v) -> System.out.println(k + " : " + v));
        map.clear();




        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5,"John");
        treeMap.put(2,"Mary");
        treeMap.put(6,"Don");
        treeMap.put(4,"Arya");
        treeMap.put(1,"John");

        treeMap.forEach((k, v) -> System.out.println(k + " : " + v));

    }
}
