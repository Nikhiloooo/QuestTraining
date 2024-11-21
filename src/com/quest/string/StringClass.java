package com.quest.string;

public class StringClass {
    public static void main(String[] args) {
        String s1="hello";
        String s2="hello world";

        String s3=new String("hello");
        String s4=new String("hello world");


        System.out.println("integer");
        int i1=2;
        int i2=2;
        check2(i1,i2);


        System.out.println("----------------------");
        String s5=s4;
        check(s1,s2);

        System.out.println("----------------------");
        check(s3,s4);

        System.out.println("----------------------");
        check(s4,s5);
        System.out.println("------------------");
        check3(s3,s4);
    }

public static void check(String s1,String s2)
    {
        if(s1==s2){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

        if(s1.equals(s2)){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

        if(s1.contains(s2)){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

    }

    public static void check2(int s1,int s2) {
        if (s1 == s2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void check3(String s1,String s2) {

        if (s1.contains("hello")) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }

}
