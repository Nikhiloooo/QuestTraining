package com.quest.oops.test2;

public class B {

    void add(int a,int b)
    {
        int c=a+b;
        System.out.println("B class Add   with 2 parameter : "+c);
    }
    void add(){
        System.out.println("B class Add  with no parameter: ");
    }

    static void add(int a){
        System.out.println(" a inside static add "+a);
    }

}
