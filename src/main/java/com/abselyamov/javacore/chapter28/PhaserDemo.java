package com.abselyamov.javacore.chapter28;

import java.util.concurrent.Phaser;

/**
 * An example of Phaser.
 */
public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhase;

        System.out.println("Starting.");

        new MyThreadPhase(phaser, "A");
        new MyThreadPhase(phaser, "B");
        new MyThreadPhase(phaser, "C");

        //  Wait for all threads to complete phase one.
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete.");

        //  Wait for all threads to complete phase two.
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete.");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete.");

        //  Deregister the main thread.
        phaser.arriveAndDeregister();

        if (phaser.isTerminated())
            System.out.println("The Phaser is terminated");
    }
}

// A thread of execution that uses a Phaser.
class MyThreadPhase implements Runnable {
    Phaser phsr;
    String name;

    public MyThreadPhase(Phaser p, String n) {
        this.phsr = p;
        this.name = n;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " Beginning Phase One.");
        phsr.arriveAndAwaitAdvance();   //  Signal arrival.

        //  Pause a bit to prevent jumbled output. This is for illustration only.
        //  It is not required for the proper operation of the phaser.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Two.");
        phsr.arriveAndAwaitAdvance();   //  Signal arrival.

        // Pause a bit to prevent jumbled output. This is for illustration
        // only. It is not required for the proper operation of the phaser.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Three");
        phsr.arriveAndDeregister(); // Signal arrival and deregister.
    }
}
