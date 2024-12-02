package com.quest.collection.practicequestions;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate {
    public static void main(String[] args) {
        int[] numbers={1,3,4,2,5,3,6,4};
        Set<Integer> set=new HashSet<>();
        int firstDuplicate=-1;
        for(int number:numbers){
            if(set.contains(number)){
                firstDuplicate=number;
                break;
            }
            set.add(number);
        }
        if(firstDuplicate!=-1){
            System.out.println("first duplicate : "+firstDuplicate);
        }
        else{
            System.out.println("no duplicates");
        }
    }
}
