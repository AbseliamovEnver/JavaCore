package com.abselyamov.javacore.chapter18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author Enver on 28.05.2019 19:04.
 * @project javacore
 * <p>
 * class HashSet<E> extends AbstractSet implements Set. (does not guarantee the order of its elements)
 * class LinkedHashSet<E> extends HashSet. (maintains a linked list of the entries in the set, in the order in which they were inserted)
 */
public class HashSetDemo {
    public static void main(String[] args) {
        // Create a hash set.
        HashSet<String> hs = new HashSet<String>();
        HashSet<String> hs3 = new HashSet<String>(10);
        HashSet<String> hs4 = new HashSet<String>(15, 0.65f);

        // Add elements to the hash set.
        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");

        HashSet<String> hs5 = new HashSet<String>(hs);

        System.out.println("HashSet original : " + hs);

        HashSet<String> hs2 = (HashSet<String>) hs.clone();

        System.out.println("Clone HashSet original: " + hs2);

        // create an iterator
        Iterator iterator = hs2.iterator();

        // check values
        System.out.println("==================================");
        System.out.print("hs2 iterator: ");

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }

        System.out.println("\n==================================");

        hs2.clear();
        System.out.println("hs2 clear: " + hs2);
        System.out.println("==================================");

        System.out.println("hs2 is empty: " + hs2.isEmpty());

        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        LinkedHashSet<String> lhs1 = new LinkedHashSet<String>(10);
        LinkedHashSet<String> lhs2 = new LinkedHashSet<String>(10, 0.75f);

        // Add elements to the linked hash set.
        lhs.add("Beta");
        lhs.add("Alpha");
        lhs.add("Eta");
        lhs.add("Gamma");
        lhs.add("Epsilon");
        lhs.add("Omega");

        LinkedHashSet<String> lhs3 = new LinkedHashSet<String>(lhs);

        System.out.println("LinkedHashSet: " + lhs);
    }
}
