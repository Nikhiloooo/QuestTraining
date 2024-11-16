package com.quest.practice_vars;

public class RepeatedCharater {
    public static void main(String[] args) {
        String str="nikhil";
        int arr[]=new int[128];
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            arr[c]++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0)
            {
                System.out.println((char)(i)+" - "+arr[i]);
            }
        }
    }
}
