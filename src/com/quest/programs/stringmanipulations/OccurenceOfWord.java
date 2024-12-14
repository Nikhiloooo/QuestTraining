package com.quest.programs.stringmanipulations;

import java.util.Scanner;

public class OccurenceOfWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = "This is a sentence and this is another sentence inside a sentence";
        System.out.println("enetr the word ");
        String word = sc.nextLine();
        String[] words = sentence.split(" ");
        int count=0;
        for(String w : words) {
            if(w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        System.out.println(word+" : "+count);
    }
}
