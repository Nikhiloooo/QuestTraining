package com.quest.collection.practicequestions.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveEvenNumbers {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("orginal : "+list);
//        list.removeIf(num -> num % 2 == 0);
        removeEven(list);
        System.out.println("after remove: "+list);
    }
    public static void removeEven(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 == 0) {
                iterator.remove();
            }
        }
    }
}
