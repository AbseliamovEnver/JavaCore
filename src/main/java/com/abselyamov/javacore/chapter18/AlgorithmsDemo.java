package com.abselyamov.javacore.chapter18;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Enver on 01.06.2019 0:23.
 * @project javacore
 * <p>
 * Demonstrate various algorithms.
 */
public class AlgorithmsDemo {
    public static void main(String[] args) {

        // Create and initialize linked list.
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(-8);
        linkedList.add(20);
        linkedList.add(-20);
        linkedList.add(8);

        // Create a reverse order comparator.
        Comparator<Integer> comparator = Collections.reverseOrder();

        // Sort list by using the comparator.
        Collections.sort(linkedList, comparator);

        System.out.println("list sorted in revers: ");

        for (int i : linkedList)
            System.out.print(i + " ");

        System.out.println();

        // Shuffle list.
        Collections.shuffle(linkedList);

        // Display randomized list.
        System.out.println("List shuffled: ");
        for (int i : linkedList)
            System.out.print(i + " ");

        System.out.println();

        System.out.println("Minimum: " + Collections.min(linkedList));
        System.out.println("Maximum: " + Collections.max(linkedList));
    }
}
