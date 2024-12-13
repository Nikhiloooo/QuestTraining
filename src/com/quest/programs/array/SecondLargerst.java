package com.quest.programs.array;

public class SecondLargerst {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 4, 45, 99};
        if (arr1.length < 2) {
            System.out.println("no second largest");
            return;
        }
        for(int i=0; i<arr1.length; i++){
            for(int j=i+1; j<arr1.length; j++){
                if(arr1[i] > arr1[j]){
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        int max = arr1[arr1.length - 1];
        for (int i = arr1.length - 2; i >= 0; i--) {
            if (arr1[i] < max) {
                System.out.println(arr1[i]);
                break;
            }
        }

    }

}
