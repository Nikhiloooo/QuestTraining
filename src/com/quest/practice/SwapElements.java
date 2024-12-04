package com.quest.practice;

import java.util.Arrays;

public class SwapElements {
    public static void main(String[] args) {
        int[] arr={1,3,2,7,4,5,6};
        int n1=3;
        int n2=5;
        if(n1<arr.length && n2<arr.length){
            int temp=arr[n1];
            arr[n1]=arr[n2];
            arr[n2]=temp;
            System.out.println("After swapping: " + Arrays.toString(arr));
        }
        else{
            System.out.println("out of array");
        }
    }
}
