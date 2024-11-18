package com.quest.oops.interfaces;

public class Result implements InterfaceA,InterfaceB {

    @Override
    public void add() {
        System.out.println("interface  A add method");

    }


    @Override
    public void add1() {
        System.out.println("interface  B add1 method");

    }

    @Override
    public void subtract() {
        System.out.println("interface  B sub method");

    }

    public static void main(String[] args) {
        Result r = new Result();
        System.out.println("object of r is created");
        r.subtract();
        r.add();
        r.add1();
    }
}
