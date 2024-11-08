package com.quest.practice_vars;
import java.util.Scanner;
public class Primenumber
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n1=sc.nextInt();
        isPrime(n1);

    }

   static void  isPrime(int n)
    {
        int c=0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                c++;
            }
        }
        if(c==2)
        {
            System.out.println("Prime Number");
        }
        else{
            System.out.println("Not Prime Number");
        }
    }

}
