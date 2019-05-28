package com.abselyamov.javacore.chapter18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Enver on 28.05.2019 14:10.
 * @project javacore
 * <p>
 * class ArrayList<E> extends AbstractList implements List.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        // Create an array list.
        ArrayList<String> al = new ArrayList<String>();
        ArrayList<String> al2 = new ArrayList<String>(10);

        System.out.println("Initial size of al: " + al.size());

        // Add elements to the array list.
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");

        System.out.println("Size of al after additions: " + al.size());

        // Display the array list.
        System.out.println("Contents of al: " + al);

        // Remove elements from the array list.
        al.remove("F");
        al.remove(2);

        System.out.println("Size of al after deletions: " + al.size());
        System.out.println("Contents of al: " + al);

        System.out.println("Gets element of index: " + al.get(2));
        System.out.println(al);

        ArrayList<String> al3 = new ArrayList<String>(al);

        System.out.println("Equals al and al3: " + al.equals(al3));

        System.out.println("ArrayList al2 is empty: " + al2.isEmpty());

        System.out.println("Clone al: " + al.clone());

        System.out.println("al add all in al3: " + al3.addAll(al));

        System.out.println("al contains \"B\": " + al.contains("B"));

        System.out.println("al last index of \"E\": " + al.lastIndexOf("E"));

        System.out.println("al to array: " + Arrays.toString(al.toArray()));

        Iterator<String> is = al.iterator();
        while (is.hasNext()) {
            String s = is.next();
            System.out.println(s);
        }

        al2.add("C");
        al2.add("W2");
        al2.add("Q");
        al2.add("B");
        al2.add("D3");

        System.out.println("===================================");
        System.out.println("array list al: " + al);
        System.out.println("array list al2: " + al2);

        System.out.println("al retain all al2: " + al.retainAll(al2));
        System.out.println("array list al: " + al);
        System.out.println("array list al2: " + al2);
        System.out.println("===================================");

        ArrayList<String> al4 = new ArrayList(10);

        al4.add("H");
        al4.add("E");
        al4.add("L");
        al4.add("L");
        al4.add("O");

        System.out.println(al4);
        al4.trimToSize();
        System.out.println(al4);
    }
}
