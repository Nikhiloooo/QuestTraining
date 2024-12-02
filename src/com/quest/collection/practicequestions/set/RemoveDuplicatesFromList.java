package com.quest.collection.practicequestions.set;

import java.util.*;

public class RemoveDuplicatesFromList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape"));
    Set<String> set = new HashSet<>(list);
        System.out.println("after removing duplicates " +set);

    }
}
