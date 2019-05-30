package com.abselyamov.javacore.chapter18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Enver on 30.05.2019 19:06.
 * @project javacore
 * <p>
 * interface Iterator enables you to cycle through a collection, obtaining or removing elements.
 * interface ListIterator  extends Iterator to allow bidirectional traversal of a list, and the modification of elements.
 * ListIterator is available only to those collections that implement the List interface.
 */
public class IteratorDemo {
    public static void main(String[] args) {
        // Create an array list
        ArrayList<String> arrayList = new ArrayList<>();

        // Add elements to the ArrayList.
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("F");

        // Use iterator to  display contents of arrayList
        System.out.print("Original contents of arrayList: ");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + " ");
        }

        System.out.println();

        // Modify objects being iterated.
        ListIterator<String> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            listIterator.set(element + "+");
        }

        System.out.print("Modified contents of arrayList: ");
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + " ");
        }

        System.out.println();

        // Now display the list backwards.
        System.out.print("Modified list backwards: ");
        while (listIterator.hasPrevious()) {
            String element = listIterator.previous();
            System.out.print(element + " ");
        }

        System.out.println();
    }
}
