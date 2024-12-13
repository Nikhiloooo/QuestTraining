package com.quest.programs.strings;

import java.util.Scanner;

public class FirstNonRepeatingCharater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = sc.nextLine();
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            int count = 0;
            for (int j = 0; j < s1.length; j++) {
                if (s1[i] == s1[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(s1[i]);
                break;
            }
        }
    }

}
