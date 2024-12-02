package com.quest.collection.practicequestions.list;

import java.util.*;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 2, 4, 1, 8, 9, 9, 9));
        if (list.size() < 2) {
            System.out.println("Not enough elements");
            return;
        }
        Collections.sort(list);

        int max = list.get(list.size() - 1);
        int i = list.size() - 1;
        while (i >= 0) {
            if (list.get(i) < max) {
                System.out.println("second largest : " + list.get(i));
                return;
            }
            i--;
        }
        System.out.println("No second largest element");
    }
}
