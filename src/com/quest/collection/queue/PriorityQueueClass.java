package com.quest.collection.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

public class PriorityQueueClass {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();

        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(8);
        pq.add(5);
        pq.add(7);
        pq.add(9);

//        Iterator<Integer> itr=pq.iterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }

        PriorityQueue<String> pq1=new PriorityQueue<>();
        //its Following FIFO
        pq1.add("hello");
        pq1.add("world");
        pq1.add("what");
        pq1.add("a");
        pq1.add("beautiful");
        pq1.add("world");

        pq1.forEach(System.out::println);

        System.out.println();
        System.out.println("pq1.size() "+pq1.size());
        System.out.println("add        "+pq1.add("bibi"));
        System.out.println("offer      "+pq1.offer("nikhil"));
        System.out.println("peek       "+pq1.peek());
        System.out.println("element    "+pq1.element());
        System.out.println("pq1.poll() "+pq1.poll());
        System.out.println("remove     "+pq1.remove());
        System.out.println();
        pq1.forEach(System.out::println);







        Stack<String> st1=new Stack<>();
        //its Following LIFO
        st1.add("hello");
        st1.add("world");
        st1.add("what");
        st1.add("a");
        st1.add("beautiful");
        st1.add("world");

//        st1.forEach(System.out::println);
//
//        System.out.println(st1.peek());
    }
}
