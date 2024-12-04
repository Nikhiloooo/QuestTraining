package com.quest.oops.multipleinheritance;

public class NewClass implements InterfaceA, InterfaceB {


    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");

    }

    @Override
    public void method3() {
        InterfaceA.super.method3();
        InterfaceB.super.method3();
    }
}
