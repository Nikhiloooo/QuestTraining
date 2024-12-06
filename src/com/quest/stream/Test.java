package com.quest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(6);

        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());
        int max = list.stream().max(Integer::compareTo).get();
        int min = list.stream().min(Integer::compareTo).get();
        System.out.println("max "+max);
        System.out.println("min "+min);
        System.out.println("count "+list.stream().count());
        System.out.println(list.stream().distinct().count());
        System.out.println(list.stream().reduce(0, Integer::sum));


        List<Integer> list2=list.stream().filter(i ->i%2==0).toList();
        System.out.println("list 1 "+list2);

        List<Integer> list3=list.stream().map(i ->i*2).toList();
        System.out.println("list 3 "+list3);


        Integer list4=list.stream().map(i ->i*2).reduce(0, Integer::sum);
        System.out.println(list4);

        Integer x=list.stream().map(i ->i*2).min(Integer::compareTo).get();
        Integer y=list.stream().map(i ->i*2).max(Integer::compareTo).get();
        System.out.println("min "+x+" max "+y  );

    }

}
