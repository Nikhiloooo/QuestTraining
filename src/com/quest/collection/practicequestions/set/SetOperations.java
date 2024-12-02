package com.quest.collection.practicequestions.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6,7,8));

        Set<Integer> union=new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("union "+union);


        Set<Integer> intersection=new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("intersection "+intersection);

        Set<Integer> difference=new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("difference "+difference);

    }
}
