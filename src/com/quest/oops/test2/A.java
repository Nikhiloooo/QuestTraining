package com.quest.oops.test2;

public class A extends B {
    public static void main(String[] args) {

        A a = new A();
        a.add(5,8);


    }
    A()
    {

        System.out.println("A class constructor");
    }

    void add()
    {
        this.add();
        System.out.println("A class add method with no argunnbet");
    }
@Override
    void add(int a,int b){
        super.add(a,b);

        int c=a+b;
        System.out.println("A class add method with argunnbet: "+c);
    }

    static void add(int a){
        System.out.println("inside static add "+a);
    }

}
