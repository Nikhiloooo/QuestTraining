package com.quest.practice_vars;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 1, 8, 4, 9, 9, 9};
        if (arr.length < 2) {
            System.out.println("No second largest element");
            return;
        }
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int i = arr.length - 2;
        while (i >= 0) {
            if (arr[i] < max) {
                System.out.println(arr[i]);
                break;
            }i--;
        }

    }

}