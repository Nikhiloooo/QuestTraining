package com.quest.programs.strings;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flag = true;
            for (int j = 0; j < s2.length(); j++) {
                if (c == s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                s2 = s2 + c;
            }
        }
        System.out.println(s2);
    }
}
