package com.quest.collection.practicequestions.list;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("orginal : "+list);

        reverseList(list);
        System.out.println("reverse : "+list);

    }

    public static void reverseList(List<Integer> list) {
        int start=0;
        int end=list.size()-1;

        while(start<end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }

    }
}
