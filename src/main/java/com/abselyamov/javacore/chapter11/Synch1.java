package com.abselyamov.javacore.chapter11;

/**
 * This program uses a synchronized block.
 */
class CallmeSynch {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class CallerSynch implements Runnable {
    String msg;
    CallmeSynch target;
    Thread t;

    public CallerSynch(CallmeSynch targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    // synchronize calls to call()
    @Override
    public void run() {
        synchronized (target) {     // synchronized block
            target.call(msg);
        }
    }
}

public class Synch1 {
    public static void main(String args[]) {
        CallmeSynch target = new CallmeSynch();
        CallerSynch ob1 = new CallerSynch(target, "Hello");
        CallerSynch ob2 = new CallerSynch(target, "Synchronized");
        CallerSynch ob3 = new CallerSynch(target, "World");

        // wait for threads to end
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
