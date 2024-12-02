package com.quest.collection.practicequestions.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDivisibleByThree {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        set.removeIf(x -> x % 3 == 0);
        System.out.println("new "+set);
    }
}
