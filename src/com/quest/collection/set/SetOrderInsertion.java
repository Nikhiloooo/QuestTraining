package com.quest.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetOrderInsertion {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<Integer>();
        System.out.println("-------------hashSet1 adding 100 elements----------");
        for (int i = 1; i <= 100; i++) {
            hashSet1.add(i);
        }
        for (Integer i : hashSet1) {
            System.out.print(i + " ");
        }
        System.out.println();
        LinkedHashSet<Integer> linkledhashSet1 = new LinkedHashSet<Integer>();
        System.out.println("-------------LinkedHashSet1 adding 100 elements----------");
        for (int i = 1; i <= 100; i++) {
            linkledhashSet1.add(i);
        }
        for (Integer i : linkledhashSet1) {
            System.out.print(i + " ");
        }

        System.out.println();
        TreeSet<Integer> treeSet1 = new TreeSet<Integer>();
        System.out.println("-------------TreeSet1 adding 100 elements----------");
        for (int i = 1; i <= 100; i++) {
            treeSet1.add(i);
        }
        for (Integer i : treeSet1) {
            System.out.print(i + " ");
        }


        System.out.println("----------------------------------------------------------");

        HashSet<Integer> hashSet2 = new HashSet<Integer>();
        System.out.println("-------------hashSet2 adding Random elements----------");
        hashSet2.add(10);
        hashSet2.add(6);
        hashSet2.add(2);
        hashSet2.add(8);
        hashSet2.add(4);
        hashSet2.add(1);
        hashSet2.add(9);
        hashSet2.add(3);
        hashSet2.add(5);
        hashSet2.add(7);

        for (Integer i : hashSet2) {
            System.out.print(i + " ");
        }
        System.out.println();

        LinkedHashSet<Integer> LinkedhashSet2 = new LinkedHashSet<>();
        System.out.println("-------------LinlkedhashSet2 adding Random elements----------");
        LinkedhashSet2.add(10);
        LinkedhashSet2.add(6);
        LinkedhashSet2.add(2);
        LinkedhashSet2.add(8);
        LinkedhashSet2.add(4);
        LinkedhashSet2.add(1);
        LinkedhashSet2.add(9);
        LinkedhashSet2.add(3);
        LinkedhashSet2.add(5);
        LinkedhashSet2.add(7);

        for (Integer i : LinkedhashSet2) {
            System.out.print(i + " ");
        }
        System.out.println();

        TreeSet<Integer> treeSet2 = new TreeSet<>();
        System.out.println("-------------TreeSet2 adding Random elements----------");
        treeSet2.add(10);
        treeSet2.add(6);
        treeSet2.add(2);
        treeSet2.add(8);
        treeSet2.add(4);
        treeSet2.add(1);
        treeSet2.add(9);
        treeSet2.add(3);
        treeSet2.add(5);
        treeSet2.add(7);

        for (Integer i : treeSet2) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("----------------------------------------------------------");

        HashSet<String> hashSet3 = new HashSet<String>();
        System.out.println("-------------hashSet3 adding Random elements with null----------");
        hashSet3.add("hello");
        hashSet3.add("how");
        hashSet3.add("are");
        hashSet3.add(null);
        hashSet3.add("you");
        hashSet3.add("are");
        hashSet3.add("you");
        hashSet3.add("okay");
        hashSet3.add(null);

        for (String s : hashSet3) {
            System.out.print(s + " ");
        }
        System.out.println();

        LinkedHashSet<String> linkedhashSet3 = new LinkedHashSet<String>();
        System.out.println("-------------LinkedhashSet3 adding Random elements with null----------");
        linkedhashSet3.add("hello");
        linkedhashSet3.add("how");
        linkedhashSet3.add("are");
        linkedhashSet3.add(null);
        linkedhashSet3.add("you");
        linkedhashSet3.add("are");
        linkedhashSet3.add("you");
        linkedhashSet3.add("okay");
        linkedhashSet3.add(null);

        for (String s : linkedhashSet3) {
            System.out.print(s + " ");
        }
        System.out.println();

try {
    TreeSet<String> treeSet3 = new TreeSet<String>();
    System.out.println("-------------treeSet3 adding Random elements with null----------");
    treeSet3.add("hello");
    treeSet3.add("how");
    treeSet3.add("are");
    treeSet3.add(null);
    treeSet3.add("you");
    treeSet3.add("are");
    treeSet3.add("you");
    treeSet3.add("okay");
    treeSet3.add(null);

    for (String s : treeSet3) {
        System.out.print(s + " ");
    }
    System.out.println();
}

catch (Exception e) {
    System.out.println("Exception caught: " + e.getMessage());
}

    }
}
