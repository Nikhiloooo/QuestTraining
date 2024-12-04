package com.quest.practice;

import java.util.*;


public class MergeList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 7, 4, 0, 8));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 8, 9, 4, 2));

        List<Integer> merged = new ArrayList<Integer>();
        Set<Integer> unique = new HashSet<>();
        unique.addAll(list1);
        unique.addAll(list2);
        merged.addAll(unique);
        System.out.println(merged);
    }
}
