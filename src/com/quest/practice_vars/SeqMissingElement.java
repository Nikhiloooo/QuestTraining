package com.quest.practice_vars;
import java.util.Arrays;
public class SeqMissingElement {
    public static void main(String[] args) {
            int[] arr = {5,10,20,25,30};
            System.out.println("Input Array: " + Arrays.toString(arr));

            Arrays.sort(arr);
            int difference = (arr[arr.length - 1] - arr[0]) / arr.length;

            for (int i = 0; i < arr.length; i++) {
                int expected = arr[0] + i * difference;
                if (arr[i] != expected) {
                    System.out.println("The missing element is: " + expected);
                    return;
                }
            }

            System.out.println("No missing element found in the sequence.");
        }
    }

