package com.quest.collection.set;

import java.util.TreeSet;

public class TreeSetClass {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);


        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
        System.out.println("-----------");
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.descendingSet());
        System.out.println(treeSet.headSet(3));
        System.out.println(treeSet.headSet(3, true));

    }
}
