package com.quest.programs.array;

public class CountEvenOdd {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int countEven = 0;
        int countOdd = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                countEven++;
            }
            else {
                countOdd++;
            }
        }
        System.out.println("Even : "+countEven);
        System.out.println("Odd : "+countOdd);
    }
}
