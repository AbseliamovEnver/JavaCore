package com.abselyamov.javacore.chapter18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Enver on 28.05.2019 19:17.
 * @project javacore
 * <p>
 * class TreeSet<E> extends AbstractSet implements NavigableSet.
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        // Create a tree set.
        TreeSet<String> treeSet = new TreeSet<String>();

        String elements[] = {"H", "E", "L", "L", "O", "!"};
        TreeSet<String> treeSet1 = new TreeSet<String>(Arrays.asList(elements));
        TreeSet<String> treeSet2 = new TreeSet<String>(treeSet1);
        TreeSet<String> treeSet3 = new TreeSet<String>(new MyComparatorTS());

        // Add elements to the tree set.
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("E");
        treeSet.add("F");
        treeSet.add("D");

        treeSet3.add("C");
        treeSet3.add("A");
        treeSet3.add("B");
        treeSet3.add("E");
        treeSet3.add("F");
        treeSet3.add("D");

        System.out.println("tree set: " + treeSet);
        System.out.println("tree set 1: " + treeSet1);
        System.out.println("tree set 2: " + treeSet2);
        System.out.println("tree set 3: " + treeSet3);

        System.out.println("tree set subSet: " + treeSet.subSet("C", "F"));

        System.out.println("tree set 1 ceiling: " + treeSet1.ceiling("N"));

        // create descending iterator
        System.out.println("====================================");

        Iterator<String> iterator = treeSet3.descendingIterator();

        System.out.println("tree set 3 descending iterator: ");

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n====================================");
    }
}

class MyComparatorTS implements Comparator<String> {
    public int compare(String a, String b) {
        String aStr, bStr;
        aStr = a;
        bStr = b;
        return bStr.compareTo(aStr);
    }
}
