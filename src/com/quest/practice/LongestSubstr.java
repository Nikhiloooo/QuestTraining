package com.quest.practice;

public class LongestSubstr {
    public static void main(String[] args) {
        String[] strArr={"hello","how","are","you","welcome","myboy"};
        String ans=strArr[0];
        int max=ans.length();
        for(String str:strArr){
            if(max<str.length()){
                max=str.length();
                ans=str;
            }
        }
        System.out.println(ans+" "+max);
    }
}
