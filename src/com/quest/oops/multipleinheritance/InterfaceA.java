package com.quest.oops.multipleinheritance;

public interface InterfaceA {
    public void method1();
    public void method2();
    default void method3() {
        System.out.println("method3 of interface  A");
    }
}
