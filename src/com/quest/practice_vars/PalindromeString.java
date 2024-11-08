package com.quest.practice_vars;
import java.sql.SQLOutput;
import java.util.Scanner;
public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str=sc.nextLine();
        String rev="";
        for(int i=0;i<str.length();i++)
        {
            rev=str.charAt(i)+rev;
        }
        if(str.equalsIgnoreCase(rev))
        {
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }
    }
}
