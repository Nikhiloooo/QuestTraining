package com.quest.collection.practicequestions.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKey {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("banana", 2);
        map.put("apple", 5);
        map.put("orange", 3);
        map.put("mango", 1);

        Map<String,Integer> sorted=new TreeMap<>(map);
        System.out.println("after sorting by key "+sorted);
    }
}
