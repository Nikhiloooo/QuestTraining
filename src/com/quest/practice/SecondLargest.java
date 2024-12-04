package com.quest.practice;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr={2,4,2,1,3,6,8,5,9,7,8};
        if(arr.length<2){
            System.out.println("no second largest");
            return;
        }
        Arrays.sort(arr);
        int max=arr[arr.length-1];
        int i=arr.length-2;
        while(i>=0){
            if(arr[i]<max){
                System.out.println(arr[i]);
                break;
            }
            i--;
        }
    }
}
