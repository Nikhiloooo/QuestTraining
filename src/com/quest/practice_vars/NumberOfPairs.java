package com.quest.practice_vars;

public class NumberOfPairs {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 10, 30, 20, 50, 40, 40, 30, 30, 10};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    if (i != j) {
                        arr[j] = -1;
                    }
                }
            }
            int pairs=count/2;
            if (pairs > 0) {
                System.out.println(arr[i] + "'s - " + pairs);
            }
        }
    }
}

