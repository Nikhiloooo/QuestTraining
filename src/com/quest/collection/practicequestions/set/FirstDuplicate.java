package com.quest.collection.practicequestions.set;

import java.util.*;

public class FirstDuplicate {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,2,3,7,8,9));
        Set<Integer> set=new HashSet<>();

        for(int num:numbers){
            if(set.contains(num)){
                System.out.println("first duplicate "+num);
                return;
            }
            else{
                set.add(num);
            }
        }
        System.out.println("no duplicate");
    }
}
