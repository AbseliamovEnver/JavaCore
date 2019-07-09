package com.abselyamov.javacore.chapter11;

/**
 * A correct implementation of a producer and consumer.
 */
class QFixed {
        int n;
        boolean valueSet = false;

synchronized int get() {
        while(!valueSet)
        try {
        wait();
        } catch(InterruptedException e) {
        System.out.println("InterruptedException caught");
        }

        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
        }

    synchronized void put(int n) {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class ProducerFixed implements Runnable {
    QFixed q;

    ProducerFixed(QFixed q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        int j = 0;

        while (j < 10) {
            q.put(i++);
            j++;
        }
    }
}

class ConsumerFixed implements Runnable {
    QFixed q;

    ConsumerFixed(QFixed q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        int k = 0;

        while (k < 10) {
            q.get();
            k++;
        }
    }
}

public class PCFixed {
    public static void main(String[] args) {
        QFixed q = new QFixed();

        new ProducerFixed(q);
        new ConsumerFixed(q);

//        System.out.println("Press Control-C to stop.");
    }
}
