package com.quest.programs.array;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        int[] temp = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < index; j++) {
                if(arr[i]==temp[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                temp[index++] = arr[i];
            }
        }
        int[] result=new int[index];
        for(int i=0;i<index;i++) {
            result[i]=temp[i];
        }
        System.out.println(Arrays.toString(result));
    }
}
