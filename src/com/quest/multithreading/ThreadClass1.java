package com.quest.multithreading;

public class ThreadClass1 extends Thread {

    public void run2(){
        System.out.println("inside run2 method-- thread name:" +
                this.currentThread());
        System.out.println("inside run 2 method-- current thread priority"
        +this.getPriority());
    }
    public void run() {
        int a=15;
        int b=17;
        int result=a+b;
        this.run2();

        System.out.println("thread started running");
        System.out.println("sum of numbers "+result );
    }
    public static void main(String[] args) {
        ThreadClass1 t1 = new ThreadClass1();
        ThreadClass1 t2 = new ThreadClass1();
        ThreadClass1 t3 = new ThreadClass1();

        t1.setPriority(1);
        t2.setPriority(7);
        t3.setPriority(4);

        t1.start();
        t2.start();
        t3.start();
    }
}
