package com.quest.collection.practicequestions.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeList {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>(Arrays.asList("apple","banana","cherry"));
        List<String> list2 = new ArrayList<String>(Arrays.asList("banana","dates","cherry","orange"));

        System.out.println("list1 "+list1);
        System.out.println("list2 "+list2);

        List<String> merged=new ArrayList<>(list1);

        for(String s : list2){
            if(!merged.contains(s)){
                merged.add(s);
            }
        }
        System.out.println("merged "+merged);
    }
}
