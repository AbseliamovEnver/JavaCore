package com.abselyamov.javacore.chapter18.comparator;

import java.util.*;

/**
 * @author Enver on 31.05.2019 19:56.
 * @project javacore
 * <p>
 * Use a comparator to sort accounts by last name.
 */
public class TreeComp implements Comparator<String> {
    // Compare last whole words in two strings.
    @Override
    public int compare(String aStr, String bStr) {
        int i, j, k;

        // Find index of beginning of last name.
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareTo(bStr.substring(j));

        if (k == 0) // last names match, check entire name
            return aStr.compareTo(bStr);
        else
            return k;
    }

    // No need to override equals.
}

class TreeMapDemo2 {
    public static void main(String[] args) {
        // Create tree map.
        TreeMap<String, Double> treeMap = new TreeMap<>(new TreeComp());

        // Put elements to the tree map.
        treeMap.put("John Doe", 3434.34);
        treeMap.put("Tom Smith", 123.22);
        treeMap.put("Jane Baker", 1378.00);
        treeMap.put("Tod Hall", 99.22);
        treeMap.put("Ralph Smith", -19.08);

        // Get a set of the entries.
        Set<Map.Entry<String, Double>> set = treeMap.entrySet();

        // Display the elements.
        for (Map.Entry<String, Double> map : set) {
            System.out.print(map.getKey() + " ");
            System.out.println(map.getValue());
        }

        System.out.println();

        // Deposit 1000 into John Doe's account.
        Double balance = treeMap.get("John Doe");
        treeMap.put("John Doe", balance + 1000);

        System.out.println("John Doe's new balance: " + treeMap.get("John Doe"));
    }
}
