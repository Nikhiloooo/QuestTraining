package com.quest.practice_vars;
import java.util.Scanner;
public class PalindromeNumber
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n1=sc.nextInt();
        int n2=n1;
        int rem=0;
        int rev=0;

        while(n1!=0)
        {
            rem=n1%10;
            rev=rev*10+rem;
            n1=n1/10;
        }
        if(n2==rev)
        {
            System.out.println("It is a palindrome number");
        }
        else{
            System.out.println("It is not a palindrome number");
        }
    }
}
