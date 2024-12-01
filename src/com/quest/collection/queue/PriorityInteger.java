package com.quest.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityInteger {
    public static void main(String[] args) {
        System.out.println("-------------Integer-------------");
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(41);
        pq.add(34);
        pq.add(13);
        pq.add(42);
        pq.add(75);
        pq.add(5);
        pq.add(71);

        for (Integer i : pq) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("peek " + pq.peek());
        System.out.println(pq.poll());
        System.out.println("peek " + pq.peek());
        System.out.println(pq.poll());
        System.out.println("peek " + pq.peek());
        System.out.println(pq.poll());
        System.out.println("peek " + pq.peek());
        System.out.println(pq.poll());
        System.out.println("peek " + pq.peek());
        System.out.println(pq.poll());
        System.out.println("peek " + pq.peek());
        System.out.println(pq.poll());
        System.out.println("peek " + pq.peek());
        System.out.println(pq.poll());


        System.out.println("---------------Double--------------");
        PriorityQueue<Double> pq1 = new PriorityQueue<>();
        pq1.add(51.2);
        pq1.add(3.4);
        pq1.add(1.3);
        pq1.add(1.3);
        pq1.add(42.2);
        pq1.add(75.3);
        pq1.add(5.3);
        pq1.add(7.1);


        for(Double i :pq1)

        {
            System.out.print(i + "  ");
        }

        System.out.println();
        System.out.println("peek "+pq1.peek());
        System.out.println(pq1.poll());
        System.out.println("peek "+pq1.peek());
        System.out.println(pq1.poll());
        System.out.println("peek "+pq1.peek());
        System.out.println(pq1.poll());
        System.out.println("peek "+pq1.peek());
        System.out.println(pq1.poll());
        System.out.println("peek "+pq1.peek());
        System.out.println(pq1.poll());
        System.out.println("peek "+pq1.peek());
        System.out.println(pq1.poll());
        System.out.println("peek "+pq1.peek());
        System.out.println(pq1.poll());



        System.out.println("---------------Character--------------");
        PriorityQueue<Character> pq2 = new PriorityQueue<>();
        pq2.add('G');
        pq2.add('Q');
        pq2.add('P');
        pq2.add('A');
        pq2.add('D');
        pq2.add('B');
        pq2.add('Z');

        for(Character i :pq2)

        {
            System.out.print(i + "  ");
        }

        System.out.println();
        System.out.println("peek "+pq2.peek());
        System.out.println(pq2.poll());
        System.out.println("peek "+pq2.peek());
        System.out.println(pq2.poll());
        System.out.println("peek "+pq2.peek());
        System.out.println(pq2.poll());
        System.out.println("peek "+pq2.peek());
        System.out.println(pq2.poll());
        System.out.println("peek "+pq2.peek());
        System.out.println(pq2.poll());
        System.out.println("peek "+pq2.peek());
        System.out.println(pq2.poll());
        System.out.println("peek "+pq2.peek());
        System.out.println(pq2.poll());



        System.out.println("---------------boolean--------------");
        PriorityQueue<Boolean> pq3 = new PriorityQueue<>();
        pq3.add(false);
        pq3.add(true);
        pq3.add(true);
        pq3.add(false);


        for(Boolean i :pq3)

        {
            System.out.print(i + "  ");
        }

        System.out.println();
        System.out.println("peek "+pq3.peek());
        System.out.println(pq3.poll());
        System.out.println("peek "+pq3.peek());
        System.out.println(pq3.poll());
        System.out.println("peek "+pq3.peek());
        System.out.println(pq3.poll());
        System.out.println("peek "+pq3.peek());
        System.out.println(pq3.poll());
    }



}


