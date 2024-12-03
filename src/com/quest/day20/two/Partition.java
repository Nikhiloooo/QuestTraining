package com.quest.day20.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        int partitionSize=2;
        List<List<Integer>> result=partitionList(list,partitionSize);
        System.out.println(result);
    }

    public static List<List<Integer>> partitionList(List<Integer> input, int n) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        for(int i=0;i<input.size();i++){
            temp.add(input.get(i));

            if(temp.size()==n){
                result.add(new ArrayList<>(temp));
                temp.clear();
            }
        }

//        if(!temp.isEmpty()){
//            result.add(temp);
//        }
        return result;

    }
}

