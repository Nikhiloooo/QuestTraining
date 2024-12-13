package com.quest.programs.strings;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string");
        String s = sc.nextLine();
        String reverse = "";
        for(int i=0;i<s.length();i++)
        {
            reverse=s.charAt(i)+reverse;
        }
        System.out.println(reverse);
    }
}
