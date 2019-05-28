package com.abselyamov.javacore.chapter18;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Enver on 28.05.2019 18:16.
 * @project javacore
 * <p>
 * class LinkedList<E> extends AbstractSequentalList implements List, Dequeue, Queue.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        // Create a linked list.
        LinkedList<String> ll = new LinkedList<String>();

        // Add elements to the linked list.
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");

        ll.addLast("Z");
        ll.addFirst("A");

        ll.add(1, "A2");

        LinkedList<String> ll2 = new LinkedList<String>(ll);

        System.out.println("Original contents of ll: " + ll);

        // Remove elements from the linked list.
        ll.remove("F");
        ll.remove(2);

        System.out.println("Contents of ll after deletion: " + ll);

        // Remove first and last elements.
        ll.removeFirst();
        ll.removeLast();

        System.out.println("Contents of ll after deleting first and last: " + ll);

        // Get and set a value.

        String value = ll.get(2);
        ll.set(2, value + " changed");

        System.out.println("Contents of ll after change: " + ll);

        // set Iterator at specified index
        Iterator x = ll.listIterator(1);

        // print list with the iterator
        while (x.hasNext()) {
            System.out.println(x.next());
        }
    }
}
