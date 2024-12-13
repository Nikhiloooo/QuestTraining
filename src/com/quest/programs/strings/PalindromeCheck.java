package com.quest.programs.strings;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter input");
        String input = sc.nextLine();
        String reverse = "";
        if(input.length()>0) {
            for(int i=0;i<input.length();i++){
                reverse = input.charAt(i)+reverse;
            }

            if(input.equalsIgnoreCase(reverse)){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }
        else{
            System.out.println("empty");
        }

    }
}
