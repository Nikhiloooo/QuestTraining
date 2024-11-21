package com.quest.string;

public class StringBuilderclass2 {
    public static void main(String[] args) {
      StringBuilder s1=new StringBuilder("hello");
        System.out.println(s1);

        s1.append("world");
        System.out.println(s1);

        s1.insert(5,"beautiful");
        System.out.println(s1);

        s1.replace(5,14,"amazing");
        System.out.println(s1);

        s1.delete(5,12);
        System.out.println(s1);

        s1.reverse();
        System.out.println(s1);

        System.out.println(s1.charAt(2));

        System.out.println(s1.toString());

        s1.deleteCharAt(5);
        System.out.println(s1);


    }
}
