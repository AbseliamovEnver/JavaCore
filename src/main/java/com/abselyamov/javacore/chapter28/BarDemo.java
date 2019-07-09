package com.abselyamov.javacore.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Here is an example that illustrates CyclicBarrier. It waits until a set of three threads has
 * reached the barrier. When that occurs, the thread specified by BarAction executes.
 */
public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarAction());

        System.out.println("Starting");

        new MyThreadCB(cyclicBarrier, "A");
        new MyThreadCB(cyclicBarrier, "B");
        new MyThreadCB(cyclicBarrier, "C");
    }
}

// A thread of execution that uses a CyclicBarrier.
class MyThreadCB implements Runnable{
    CyclicBarrier cbar;
    String name;

    MyThreadCB(CyclicBarrier cyclicBarrier, String nameThread){
        cbar = cyclicBarrier;
        name = nameThread;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

// An object of this class is called when the CyclicBarrier ends.
class BarAction implements Runnable{

    @Override
    public void run() {
        System.out.println("Barrier Reached!");
    }
}
