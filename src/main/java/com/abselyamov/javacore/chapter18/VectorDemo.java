package com.abselyamov.javacore.chapter18;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author Enver on 01.06.2019 1:48.
 * @project javacore
 * <p>
 * Demonstrate various Vector operations.
 */
public class VectorDemo {
    public static void main(String[] args) {

        // initial size is 3, increment is 2
        Vector<Integer> vector = new Vector<>(3, 2);
        System.out.println("Initial size: " + vector.size());
        System.out.println("Initial capacity: " + vector.capacity());

        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);

        System.out.println("Capacity after four additions: " + vector.capacity());

        vector.addElement(5);
        System.out.println("Current capacity: " + vector.capacity());

        vector.addElement(6);
        vector.addElement(7);
        System.out.println("Current capacity: " + vector.capacity());

        vector.addElement(9);
        vector.addElement(10);
        System.out.println("Current capacity: " + vector.capacity());

        vector.addElement(11);
        vector.addElement(12);

        System.out.println("First element: " + vector.firstElement());
        System.out.println("Last element: " + vector.lastElement());

        if (vector.contains(3))
            System.out.println("Vector contain 3.");

        // Enumerate the elements in the vector.
        Enumeration<Integer> vEnum = vector.elements();

        System.out.println("\nElement in vector using Enumeration: ");
        while (vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();

        // Use an iterator to display contents.
        Iterator<Integer> vItr = vector.iterator();

        System.out.println("\nElement in vector using Iterator: ");
        while (vItr.hasNext())
            System.out.print(vItr.next() + " ");
        System.out.println();

        // Use an enhanced for loop to display contents
        System.out.println("\nElement in vector using ForEach: ");
        for (int i : vector)
            System.out.print(i + " ");
        System.out.println();
    }
}
