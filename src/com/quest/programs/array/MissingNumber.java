package com.quest.programs.array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6};
        int start=arr[0];
        int end=arr[arr.length-1];
        int sum1=0;
        int sum2=0;
        for(int i=start; i<=end; i++){
            sum1+=i;
        }
        for(int i=0;i<arr.length;i++){
            sum2+=arr[i];
        }
        System.out.println(sum1-sum2);
    }
}
