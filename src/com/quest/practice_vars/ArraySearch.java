package com.quest.practice_vars;

public class ArraySearch {

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int value = 3;

        int result = search(numbers, value);

        if (result != -1) {
            System.out.println("Value not found.");

        } else {
            System.out.println("Value found at index: " + result);
        }
    }
}

