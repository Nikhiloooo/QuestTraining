package com.quest.practice_vars;

import java.util.Arrays;

public class ReplaceWithSumOfOther {
    public static void main(String[] args) {
        int[] arr={2,4,5,7,8};
        int i=0;
        int sum=0;
        while(i<arr.length){
            sum=sum+arr[i];
            i++;
        }
        i=0;
        while(i<arr.length){
            arr[i]=sum-arr[i];
            i++;
        }
        System.out.print(Arrays.toString(arr)+" ");

    }
}

