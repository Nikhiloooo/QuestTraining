package com.quest.string;

public class StringStringBufferStringBuilder {

    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");


        StringBuilder s4 = new StringBuilder("hello");
        StringBuilder s5 = new StringBuilder("hello");


        StringBuffer s6 = new StringBuffer("hello");
        StringBuffer s7 = new StringBuffer("hello");


        checkString(s1, s2, s3);
        System.out.println("-------------");
        checkStringBuilder(s4, s5);
        System.out.println("-------------");
        checkStringBuffer(s6, s7);

        System.out.println("-------------");
        stringBuilderMethods(s4);
        System.out.println("-------------");
        stringBufferMethods(s6);
    }


    public static void checkString(String s1, String s2, String s3) {
        System.out.println("Checking Strings:");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
    }


    public static void checkStringBuilder(StringBuilder s4, StringBuilder s5) {
        System.out.println("Checking StringBuilder:");
        System.out.println("s4 == s5: " + (s4 == s5));
        System.out.println("s4.equals(s5): " + s4.equals(s5));
    }


    public static void checkStringBuffer(StringBuffer s6, StringBuffer s7) {
        System.out.println("Checking StringBuffer:");
        System.out.println("s6 == s7: " + (s6 == s7));
        System.out.println("s6.equals(s7): " + s6.equals(s7));
    }


    public static void stringBuilderMethods(StringBuilder s4) {
        System.out.println("StringBuilderMethods:");
        System.out.println(s4);
        s4.append("world");
        System.out.println(s4);

        s4.insert(5, "beautiful");
        System.out.println(s4);

        s4.replace(5, 14, "amazing");
        System.out.println(s4);

        s4.delete(5, 12);
        System.out.println(s4);

        s4.reverse();
        System.out.println(s4);

        System.out.println(s4.charAt(2));

        System.out.println(s4);

        s4.deleteCharAt(5);
        System.out.println(s4);

        s4.setLength(4);
        System.out.println(s4);
    }


    public static void stringBufferMethods(StringBuffer s6) {
        System.out.println("StringBufferMethods:");
        System.out.println(s6);
        s6.append("world");
        System.out.println(s6);

        s6.insert(5, "beautiful");
        System.out.println(s6);

        s6.replace(5, 14, "amazing");
        System.out.println(s6);

        s6.delete(5, 12);
        System.out.println(s6);

        s6.reverse();
        System.out.println(s6);

        System.out.println(s6.charAt(2));

        System.out.println(s6);

        s6.deleteCharAt(5);
        System.out.println(s6);

        s6.setLength(4);
        System.out.println(s6);
    }
}
