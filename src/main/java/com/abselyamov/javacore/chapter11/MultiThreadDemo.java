package com.abselyamov.javacore.chapter11;

/**
 * Create multiple threads.
 */
class NewMultithread implements Runnable {
    String name;
    Thread t;

    NewMultithread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New Thread: " + t);
        t.start();   // Start the thread
    }

    // This is the entry point for thread.
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + " exiting.");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewMultithread("One");
        new NewMultithread("Two");
        new NewMultithread("Three");

        try {
            // wait for other threads to end
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
