package com.abselyamov.javacore.chapter18;

import java.util.*;

/**
 * @author Enver on 31.05.2019 3:34.
 * @project javacore
 * <p>
 * class TreeMap extends AbstractMap implements NavigableMap
 */
public class TreeMapDemo {
    public static void main(String[] args) {

        // Create a tree map.
        TreeMap<String, Double> treeMap = new TreeMap<>();
        TreeMap<String, Double> treeMap2 = new TreeMap<>(treeMap);
        TreeMap<String, Double> treeMap3 = new TreeMap<>(new MyComparatorTM());

        SortedMap<String, Double> sortedMap = new TreeMap<>();

        TreeMap<String, Double> treeMap4 = new TreeMap<>(sortedMap);

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
            System.out.print(map.getKey() + ": ");
            System.out.println(map.getValue());
        }

        System.out.println();

        // Deposit 1000 into John Doe's account.
        double balance = treeMap.get("John Doe");
        treeMap.put("John Doe", balance + 1000);
        System.out.println("John Doe's new balance: " + treeMap.get("John Doe"));
    }
}

class MyComparatorTM implements Comparator<String> {
    public int compare(String a, String b) {
        String aStr, bStr;
        aStr = a;
        bStr = b;
        return bStr.compareTo(aStr);
    }
}
