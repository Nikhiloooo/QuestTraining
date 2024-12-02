package com.quest.collection.practicequestions.map;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    public static void main(String[] args) {
        String input="hello world";
        Map<Character, Integer> map=new HashMap<>();
        for(char c:input.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }

}
