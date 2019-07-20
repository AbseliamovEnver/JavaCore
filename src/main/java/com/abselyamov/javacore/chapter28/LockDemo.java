package com.abselyamov.javacore.chapter28;

import java.util.concurrent.locks.ReentrantLock;

/**
 * A simple lock example.
 */
public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}

// A shared resource.
class SharedLock {
    static int count = 0;
}

// A thread of execution that increments count.
class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    public LockThread(ReentrantLock lock, String n) {
        this.lock = lock;
        this.name = n;

        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            // First, lock count.
            System.out.println(name + " is waiting to lock count.");
            lock.lock();
            System.out.println(name + " is locking count.");

            Shared.count++;
            System.out.println(name + ": " + Shared.count);

            // Now, allow a context switch -- if possible.
            System.out.println(name + " is sleeping.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            // Unlock.
            System.out.println(name + " is unlocking count.");
            lock.unlock();
        }
    }
}
