package com.quest.day20.two;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "cherry", "banana", "banana"));
        int k = 1;

        List<String> result = findTopKFrequent(input, k);
        System.out.println(result);
    }

    public static List<String> findTopKFrequent(List<String> input, int k) {

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : input) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }


        FrequencyComparator frequencyComparator = new FrequencyComparator();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort(frequencyComparator);


        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(entryList.get(i).getKey());
        }

        return result;
    }


    public static class FrequencyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {

                return entry2.getValue().compareTo(entry1.getValue());
        }
    }
}
