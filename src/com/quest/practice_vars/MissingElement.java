package com.quest.practice_vars;

import java.util.Arrays;

public class MissingElement {
    public static void main(String[] args) {
        int[] arr = {2,3,1,5,7,8,9,6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int start=arr[0];
        int end=arr[arr.length-1];
        int sum1=0;
        int sum2=0;
        for(int i=start;i<=end;i++){
            sum1+=i;
        }
        for(int i=0;i<arr.length;i++){
            sum2+=arr[i];
        }

      
        System.out.println(sum1-sum2);

    }
}
