package com.quest.programs.strings;

import java.util.Scanner;

public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        int countVowels = 0;
        int countConsonants = 0;
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)>='a' && s.charAt(i)<='z'||s.charAt(i)>='A'&& s.charAt(i)<='Z') {
                char c = s.charAt(i);
                if(c=='a'|| c=='e'||c=='i'||c=='o'||c=='u') {
                    countVowels++;
                }

                else {
                    countConsonants++;
                }
            }

        }
        System.out.println("Vowels : "+countVowels);
        System.out.println("Consonants : "+countConsonants);
    }
}
