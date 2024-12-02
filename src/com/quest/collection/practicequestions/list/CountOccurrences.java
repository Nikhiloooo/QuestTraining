package com.quest.collection.practicequestions.list;

import java.util.*;

public class CountOccurrences {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(6,2,4,1,8,9,9,9));
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer i : list){
          map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
