package com.quest.practice_vars;

public class JavaMethodExamples {

private static final int X=20;
    public static void main(String[] args)
    {
        JavaMethodExamples javamethodexaple = new JavaMethodExamples();
        javamethodexaple.display("hello");
       int result= javamethodexaple.add(20,30);
        System.out.println(result);

    }


    /**
     * dislay String
     * @param str -name
     */

    private void display(String str){
        System.out.println(str);
    }



    /**
     * add 2 numbers
     * @param a
     * @param b
     * @return -int
     */

    private int add(int a,int b)
    {
        return a+b;
    }

}
