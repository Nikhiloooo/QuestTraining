package com.quest.collection.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashMapClass {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "banana");
        hm.put(2, "chicken");
        hm.put(3, "apple");
        hm.put(4, "orange");
        hm.put(5, "pineapple");
        hm.put(6, "rambuttan");
        for(String s:hm.values()){
            System.out.println(s);
        }

        for(Integer i:hm.keySet()){
            System.out.println(i);
        }

        for(Map.Entry<Integer,String>  e:hm.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }

        System.out.println("hm.get(1) "+hm.get(1));
        System.out.println("hm.get(5) "+hm.get(5));

        System.out.println( hm.remove(1));
        System.out.println(hm.remove("apple"));//not get acess by value
        System.out.println(hm.size());
        System.out.println(hm.put(5,"guvava"));

        hm.clear();
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());

    }
}
