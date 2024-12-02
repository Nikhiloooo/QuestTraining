package com.quest.collection.practicequestions.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetContainsAll {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2,4,5));

        if(set1.containsAll(set2)) {
            System.out.println("Set1 contains all the elements");

        }
        else {
            System.out.println("Set1 does not contain all the elements");
        }
        if(set2.containsAll(set1)) {
            System.out.println("Set2 contains all the elements");

        }
        else {
            System.out.println("Set2 does not contain all the elements");
        }

    }
}
