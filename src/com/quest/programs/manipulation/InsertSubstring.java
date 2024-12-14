package com.quest.programs.manipulation;

import java.util.Scanner;

public class InsertSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        System.out.println("Enter the position");
        int pos = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the substring");
        String sub = sc.nextLine();
        StringBuffer str = new StringBuffer(s);
        str.insert(pos, sub);
        System.out.println("new string : "+str);
    }
}
