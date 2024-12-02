package com.quest.collection.practicequestions;
import java.util.*;
public class FreequencyCount {
    public static void main(String[] args) {
        String str="Java is fun and java is powerful";
        str = str.toLowerCase();
        String[] words = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0) + 1);

        }
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            System.out.println(entry.getKey() + "-> " + entry.getValue());
        }
    }

}
