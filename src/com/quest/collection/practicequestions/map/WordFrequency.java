package com.quest.collection.practicequestions.map;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String word ="Java is fun and java is powerful" ;
       word= word.toLowerCase();
        String[] words=word.split(" ");
        Map<String,Integer> map=new HashMap<>();
        for(String word1:words){
            map.put(word1,map.getOrDefault(word1,0)+1);
        }
        System.out.println("freequency count");
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}
