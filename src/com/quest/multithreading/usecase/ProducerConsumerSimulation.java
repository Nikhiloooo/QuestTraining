package com.quest.multithreading.usecase;

import java.util.ArrayList;
import java.util.List;

class SharedBuffer {
    private List<String> buffer = new ArrayList<String>();
    private int size;

    public SharedBuffer(int size) {
        this.size = size;
    }


    synchronized public void produce(String data) {
        if (buffer.size() == size) {
            System.out.println(Thread.currentThread().getName() + "  Buffer is full");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer.add(data);
        System.out.println("Producer  produced: " + data);
        notify();
    }

    synchronized public void consume() {
        if (buffer.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " Buffer is empty. Waiting for producer...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String item = buffer.remove(0);
            System.out.println("Consumer  consumed: " + item);


        } else {
            System.out.println("Consumer  consumed: " + buffer.remove(0));
            notify();
        }
    }
}


class ProducerThread extends Thread {
    private SharedBuffer buffer;
    private String threadName;

    public ProducerThread(SharedBuffer buffer, String threadName) {
        this.buffer = buffer;
        this.threadName = threadName;
    }

    public void run() {
        buffer.produce(threadName);
    }

}


class ConsumerThread extends Thread {
    private SharedBuffer buffer;

    public ConsumerThread(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        buffer.consume();
    }
}


public class ProducerConsumerSimulation {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(2);
        ProducerThread p1 = new ProducerThread(buffer, "Thread 1");
        ConsumerThread c1 = new ConsumerThread(buffer);
        ConsumerThread c2 = new ConsumerThread(buffer);
        ProducerThread p2 = new ProducerThread(buffer, "Thread 2");

        p1.start();
        p2.start();

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c1.start();
        c2.start();


    }
}
