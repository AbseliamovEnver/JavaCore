package com.abselyamov.javacore.chapter13;

/**
 * Demonstrate assert.
 */
public class AssertDemo {
    static int val = 3;

    // Return an integer.
    static int getnum() {
        return val--;
    }

    public static void main(String args[]) {
        int n;

        for (int i = 0; i < 10; i++) {
            n = getnum();

            assert n > 0; // will fail when n is 0
            assert n > 0 : "n is negative!";

            System.out.println("n is " + n);
        }
    }
}