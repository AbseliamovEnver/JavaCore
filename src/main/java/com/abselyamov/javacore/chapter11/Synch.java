package com.abselyamov.javacore.chapter11;

/**
 * This program is not synchronized.
 */
class Callme {
//    void call(String msg) {
        synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    CallmeSynch target;
    Thread t;

    public Caller(CallmeSynch targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        target.call(msg);
    }
}

public class Synch {
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
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
