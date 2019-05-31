package com.abselyamov.javacore.chapter18.comparator;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Enver on 31.05.2019 18:53.
 * @project javacore
 * <p>
 * Use a custom comparator.
 */
public class MyComp implements Comparator<String> {
    // A reverse comparator for strings.
    @Override
    public int compare(String aStr, String bStr) {
        // Reverse the comparison.
        return bStr.compareTo(aStr);
    }
    // No need to override equals or the default methods.

    // Use a lambda expression to implement Comparator<String>.
    //    Comparator<String> comparator = (aStr, bStr) -> aStr.compareTo(bStr);
}

class CompDemo {

    public static void main(String[] args) {
        // Create a tree set.
        TreeSet<String> treeSet = new TreeSet<>(new MyComp());

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

        // Pass a reverse order version of MyComp to TreeSet.
        MyComp myComp = new MyComp();
        TreeSet<String> treeSet1 = new TreeSet<>(myComp.reversed());

        // Add elements to the tree set.
        treeSet1.add("C");
        treeSet1.add("A");
        treeSet1.add("B");
        treeSet1.add("E");
        treeSet1.add("F");
        treeSet1.add("D");

        // Display the elements.
        for (String element : treeSet1)
            System.out.print(element + " ");

        System.out.println();
    }
}
