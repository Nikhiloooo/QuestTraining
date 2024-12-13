package com.quest.programs.stringAdvanced;

import java.util.Scanner;

public class RemoveVowels {
    public static void main(String[] args) {
        String input = "malayalabratham";
        input = input.toLowerCase();
        String newString = removeVowel(input);
        System.out.println(newString);

    }

       static String removeVowel(String input) {
           StringBuilder output=new StringBuilder();
           for(int i=0;i<input.length();i++){
               char ch=input.charAt(i);
               if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                   continue;
               }
               else {
                   output.append(ch);
               }
           }
         return output.toString();

       }


}
