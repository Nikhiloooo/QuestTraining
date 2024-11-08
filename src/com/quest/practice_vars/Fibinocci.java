package com.quest.practice_vars;
import java.util.Scanner;
public class Fibinocci
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();
        int n1=0;
        int n2=1;
        int sum=0;
        int i=1;
        System.out.println("fibinocci progarm for " +n+ " numbers");
        while(i<=n)
        {
            System.out.print(n1+" ");
            sum=n1+n2;
            n1=n2;
            n2=sum;
            i++;
        }
    }
}
