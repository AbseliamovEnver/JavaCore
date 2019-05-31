package com.abselyamov.javacore.chapter18.comparator;

import java.util.TreeSet;

/**
 * @author Enver on 31.05.2019 19:41.
 * @project javacore
 * <p>
 * Use a lambda expression to create a reverse comparator.
 */
public class CompDemo2 {
    public static void main(String[] args) {

        // Pass a reverse comparator to TreeSet() via a
        // lambda expression.
        TreeSet<String> treeSet = new TreeSet<>((aStr, bStr) -> bStr.compareTo(aStr));

        // Add elements to the tree set.
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("E");
        treeSet.add("F");
        treeSet.add("D");

        // Display the elements.
        for (String element : treeSet)
            System.out.print(element + " ");
        System.out.println();
    }
}
