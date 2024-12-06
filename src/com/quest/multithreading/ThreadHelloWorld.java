package com.quest.multithreading;

public class ThreadHelloWorld {

    public static void main(String[] args) throws InterruptedException {
       HelloWorldThread helloWorld = new HelloWorldThread();
       HelloWorldThread helloWorld2 = new HelloWorldThread();

       Thread thread = new Thread(helloWorld,"Hello");
       Thread thread2 = new Thread(helloWorld2,"World");
       Thread thread3 = new Thread(helloWorld,"!");
       thread.start();
       thread.join();
       thread2.start();
       thread2.join();
       thread3.start();
    }


    static class HelloWorldThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());

            try {
                Thread.sleep(500);

            } catch
            (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "interrupted");
            }
        }


    }


}

