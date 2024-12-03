package com.quest.day20.two;

import java.util.*;

public class Frequency {
    public static void main(String[] args) {
        List<Integer> input =new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3,4,4,4));
        Map<Integer, List<Integer>> result = groupByFrequency(input);
        System.out.println(result);
    }

    public static Map<Integer, List<Integer>> groupByFrequency(List<Integer> input) {
        Map<Integer,Integer> freequencymap = new HashMap<>();
        for(Integer i : input) {
            freequencymap.put(i,freequencymap.getOrDefault(i,0) + 1);
        }
        Map<Integer, List<Integer>> result = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : freequencymap.entrySet()) {
            int number = entry.getKey();
            int freequency = entry.getValue();

            if(!result.containsKey(freequency)){
                result.put(freequency,new ArrayList<>());
            }
            result.get(freequency).add(number);
        }
        return result;

    }
}
