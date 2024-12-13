package com.quest.programs.array;

import java.util.Arrays;
import java.util.Scanner;

public class RightRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr={1,2,3,4,5};
        System.out.println("enter steps");
        int steps=sc.nextInt();
        for(int i=0;i<steps;i++){
            rotate(arr);
        }
            System.out.println(Arrays.toString(arr));


    }

    public static void rotate(int[] arr){
        int element=arr[arr.length-1];
        for(int i=arr.length-1;i>=1;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=element;

    }
}
