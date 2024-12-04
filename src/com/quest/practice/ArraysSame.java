package com.quest.practice;

import java.util.Arrays;

public class ArraysSame {
    public static void main(String[] args) {
        int[] arr1 = {1,4,2,3,6,5,7};
        int[] arr2 = {1,5,2,7,6,4,9,7};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(Arrays.equals(arr1, arr2)){
            System.out.println("arrays has same elements");
        }
        else{
            System.out.println("arrays not have same elements");
        }
    }
}
