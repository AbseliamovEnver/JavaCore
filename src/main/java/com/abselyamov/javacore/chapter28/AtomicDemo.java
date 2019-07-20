package com.abselyamov.javacore.chapter28;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple example of Atomic.
 */
public class AtomicDemo {
    public static void main(String[] args) {
        new AtomThread("A");
        new AtomThread("B");
        new AtomThread("C");
    }
}

class SharedAtomic {
    static AtomicInteger ai = new AtomicInteger(0);
}

// A thread of execution that increments count.
class AtomThread implements Runnable {
    String name;

    public AtomThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        for (int i = 1; i <= 3; i++)
            System.out.println(name + " got: " + SharedAtomic.ai.getAndSet(i));
    }
}