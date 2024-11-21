package com.quest.string;

public class StringBuilderClass {
    public static void main(String[] args) {
        StringBuilder s1=new StringBuilder("hello");
        StringBuilder s2=new StringBuilder();
        check(s1,s2);

        s2.append("world $");
        System.out.println(s2.charAt(2));
//        System.out.println(s2.insert(0,"hello"));
//        System.out.println(s2.delete(0,2));
//        System.out.println(s2.reverse());
//        System.out.println(s2.replace(0,1,"h"));

        String s4="hello";
        String s5="world $";
        System.out.println(s4+s5);

    }


    public static void check(StringBuilder s1,StringBuilder s2) {
        if(s1==s2){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
        System.out.println("------------");

        if(s1.equals(s2)) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }

        System.out.println("------------");

        if(s1.compareTo(s2)==0) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
