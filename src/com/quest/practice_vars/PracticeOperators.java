package com.quest.practice_vars;

public class PracticeOperators
{
    public static void main(String[] args) {
        int a=10;
        int b=5;

//        arithmetic operators

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a%b);
        System.out.println(a/b);

//        relational operators
        System.out.println(a==b);
        System.out.println(a!=b);
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);


        boolean x=true;
        boolean y=false;

//        logical operators

        System.out.println(x && y);
        System.out.println(x || y);

        int z=10;
        z+=5;     //z=z+5      15

//      unary operators
        System.out.println(z);//15
        System.out.println(z++);//15
        //z=16
        System.out.println(++z);//17
        System.out.println(z);//17
        System.out.println(z--);//17
        //16
        System.out.println(--z);//15
        System.out.println(z);//15

        int p=10;
        int q=5;
//      turnary operator
       int result= p>10 ? ++q : 0;
        System.out.println(result);
    }
}
