package com.quest.programs.strings;

import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string1: ");
        String string1 = sc.nextLine();
        System.out.println("Enter the string2: ");
        String string2 = sc.nextLine();
        if(string1.length()==string2.length()) {
            String s1=sort(string1);
            String s2=sort(string1);
            if(s1.equalsIgnoreCase(s2)) {
                System.out.println("Anagram");
            }
            else {
                System.out.println("Not Anagram");
            }
        }
        else {
            System.out.println("The strings are not anagram");
        }
    }
    static String sort(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if(chars[i]>chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }
}
