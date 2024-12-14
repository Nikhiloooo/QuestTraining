package com.quest.programs.subarray;

public class LongestSubArray {
    public static void main(String[] args) {
        int[] arr={1,2,8,6,7,5};
        int k=12;
        int maxLength=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum=sum+arr[j];
                if(sum==k){
                    maxLength=Math.max(maxLength,j-i+1);

                }
            }
        }
        System.out.println(maxLength);
    }

}
