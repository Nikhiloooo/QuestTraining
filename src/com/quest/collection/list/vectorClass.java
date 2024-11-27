package com.quest.collection.list;
import java.util.Vector;

public class vectorClass {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);

        System.out.println(vector.size());
        System.out.println(vector.get(0));
        System.out.println(vector.add(5));
        System.out.println(vector.contains(3));
        System.out.println(vector.remove(2));
        System.out.println(vector.isEmpty());
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());



    }
}
