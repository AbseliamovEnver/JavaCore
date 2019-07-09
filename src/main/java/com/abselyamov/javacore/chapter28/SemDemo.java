package com.abselyamov.javacore.chapter28;

import java.util.concurrent.Semaphore;

/**
 * A simple semaphore example.
 */
public class SemDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new IncTread(semaphore, "A");
        new DecTread(semaphore, "B");
    }
}

// A shared resource.
class Shared {
    static int count = 0;
}

// A thread of execution that increments count.
class IncTread implements Runnable {
    String name;
    Semaphore semaphore;

    public IncTread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            // First, get a permit
            System.out.println(name + " is waiting for a permit.");
            semaphore.acquire();
            System.out.println(name + " gets a permit.");

            // Now access shared resource.
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                // Now, allow a context switch -- if possible.
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Release the permit.
        System.out.println(name + " releases the permit.");
        semaphore.release();
    }
}

// A thread of execution that decrement count.
class DecTread implements Runnable {
    String name;
    Semaphore semaphore;

    DecTread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            // First, get a permit.
            System.out.println(name + " is waiting for a permit.");
            semaphore.acquire();
            System.out.println(name + " gets a permit");

            // Now, access shared resource.
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                // Now, allow a context switch -- if possible.
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Release the permit.
        System.out.println(name + " releases the permit.");
        semaphore.release();
    }
}
