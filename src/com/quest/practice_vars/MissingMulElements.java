package com.quest.practice_vars;
import java.util.Arrays;
public class MissingMulElements {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,8,10};
        Arrays.sort(arr);
        int start=arr[0];
        int end=arr[arr.length-1];
        for(int j=start;j<end;j++)
        {
            boolean flag=false;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==j){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.print(j+"  ");
            }
        }
    }
}
