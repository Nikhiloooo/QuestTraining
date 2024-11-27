package com.quest.collection.set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetClass {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(2);
        set.add(4);
        set.add(6);
        set.add(1);    //dont follow order of insertion it internally sort the elements
        set.add(6);//not allow duplicate
//        set.add(null);//doesnot accept null value

//
//        ArrayList<Integer> l1=new ArrayList<Integer>();
//        l1.add(1);
//        l1.add(2);
//        l1.add(3);
//        l1.add(4);
//        l1.add(5);
//        l1.add(6);
//        l1.add(null);
//
//        for(Integer i : l1){
//            System.out.println("for list : "+i)
//        }

        System.out.println("size "+set.size());
        System.out.println("set.isEmpty() "+set.isEmpty());
        System.out.println("set.contains(5) "+set.contains(5));
        System.out.println(set.remove(3));
        for (int i : set) {
            System.out.println("for set : "+i);
        }
        set.clear();

    }
}
