package com.quest.programs.subarray;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int[] nums={-3,-1,5,1,4,2,6,7};
        int n=nums.length;
        int pcount=partition(nums);

        for(int i=0;i<pcount;i++){
            int absValue=Math.abs(nums[i]);
            if(absValue-1<pcount && nums[absValue-1]>0){
                nums[absValue-1]=-nums[absValue-1];
            }
        }

        for(int i=0;i<pcount;i++){
            if(nums[i]>0){
                System.out.println(i+1);
                break;
            }
        }
        System.out.println("no missing number");


    }

    public static int partition(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
        return j;
    }
}
