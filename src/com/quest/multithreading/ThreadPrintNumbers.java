package com.quest.multithreading;

public class ThreadPrintNumbers {
    public static void main(String[] args) {
        System.out.println("main method started");
        ThreadOdd threadOdd = new ThreadOdd();
        ThreadEven threadEven = new ThreadEven();
        threadEven.setPriority(1);
        threadOdd.setPriority(6);
        threadOdd.start();
        threadEven.start();
        System.out.println("main method ended");

    }

}
class ThreadOdd extends Thread {
    @Override
    public void run() {
        System.out.println("printing odd numbers");
        for(int i=1;i<=10;i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }

}

class ThreadEven extends Thread {
    @Override
    public void run() {
        System.out.println("printing even numbers");
        for(int i=1;i<=10;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}
