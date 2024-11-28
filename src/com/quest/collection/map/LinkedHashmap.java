package com.quest.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashmap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(7, "A");
        linkedHashMap.put(5, "B");
        linkedHashMap.put(6, "C");
        linkedHashMap.put(4, "D");
        linkedHashMap.put(2, "E");
        linkedHashMap.put(3, "F");
        linkedHashMap.put(1, "G");

        System.out.println(linkedHashMap.keySet());
        System.out.println(linkedHashMap.values());

        for(Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("for each lambda expression");
        linkedHashMap.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("size " +linkedHashMap.size());
        System.out.println(linkedHashMap.entrySet());
        linkedHashMap.put(5,"K");
        System.out.println(linkedHashMap.entrySet());
        System.out.println("key 6 present "+linkedHashMap.containsKey(6));
        System.out.println("value K present "+linkedHashMap.containsValue("K"));
        System.out.println("is empty "+linkedHashMap.isEmpty());
        System.out.println(linkedHashMap.remove(2,"B"));
        System.out.println(linkedHashMap.replace(7,"G","A"));
        System.out.println(linkedHashMap.entrySet());

    }
}
