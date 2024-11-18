package com.quest.practice_vars;
public class ReverseArray {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int l = 0;
                int h = arr[i].length - 1;
                while (l < h) {
                    int temp = arr[i][l];
                    arr[i][l] = arr[i][h];
                    arr[i][h] = temp;
                    l++;
                    h--;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}




