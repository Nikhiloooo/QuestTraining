package com.quest.programs.subarray;

import java.util.Arrays;

public class ReArrangeOddEven {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        for(int i = 0; i<arr.length-1; i++){
            if(i%2==0 && arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        else if(i%2!=0 && arr[i]<arr[i+1]){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;

            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
