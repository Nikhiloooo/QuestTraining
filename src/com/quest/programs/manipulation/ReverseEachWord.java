package com.quest.programs.manipulation;

public class ReverseEachWord {
    public static void main(String[] args) {
      String str="hello hi welcome bye";
      String[] arr=str.split(" ");
     for(String word:arr){
         System.out.print(reverse(word)+" ");
     }
    }
    public static String reverse(String str){
        StringBuilder rev = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            rev.append(str.charAt(i));
        }
        return rev.toString();

    }
}
