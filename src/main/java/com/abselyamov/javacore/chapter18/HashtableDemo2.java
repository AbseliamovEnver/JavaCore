package com.abselyamov.javacore.chapter18;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Enver on 01.06.2019 3:01.
 * @project javacore
 * <p>
 * class Hashtable was part of the original java.util and is a concrete implementation of a Dictionary.
 * Demonstrate a Hashtable. Use iterators with a Hashtable.
 */
public class HashtableDemo2 {
    public static void main(String[] args) {
        Hashtable<String, Double> balance = new Hashtable<>();

        String str;
        double bal;

        balance.put("John Doe", 3434.34);
        balance.put("Tom Smith", 123.22);
        balance.put("Jane Baker", 1378.00);
        balance.put("Tod Hall", 99.22);
        balance.put("Ralph Smith", -19.08);

        // Show all balances in hashtable.
        // First, get a set view of the keys.
        Set<String> set = balance.keySet();

        // Get an iterator
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            str = iterator.next();
            System.out.println(str + ": " + balance.get(str));
        }

        System.out.println();

        // Deposit 1,000 into John Doe's account.
        bal = balance.get("John Doe");
        balance.put("John Doe", bal + 1000);
        System.out.println("John Doe's new balance: " + balance.get("John Doe"));
    }
}
