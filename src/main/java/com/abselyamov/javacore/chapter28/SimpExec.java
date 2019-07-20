package com.abselyamov.javacore.chapter28;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A simple example that uses an Executor.
 */
public class SimpExec {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Starting");

        // Start the threads.
        es.execute(new MyThreadEx(cd1, "A"));
        es.execute(new MyThreadEx(cd2, "B"));
        es.execute(new MyThreadEx(cd3, "C"));
        es.execute(new MyThreadEx(cd4, "D"));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        es.shutdown();
        System.out.println("Done!");
    }
}

class MyThreadEx implements Runnable {
    String name;
    CountDownLatch latch;

    public MyThreadEx(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;

        new Thread(this);
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
