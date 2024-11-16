package com.quest.practice_vars;

public class DuplicateElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 54, 34, 33, 4, 4, 3};
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
            if (count > 1) {
                System.out.println(arr[i] + " - " + count);
            }
        }

    }
}