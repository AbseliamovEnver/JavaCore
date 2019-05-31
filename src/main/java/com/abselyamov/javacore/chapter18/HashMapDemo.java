package com.abselyamov.javacore.chapter18;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Enver on 31.05.2019 2:20.
 * @project javacore
 * <p>
 * class HashMap extends AbstractMap implements Map
 */
public class HashMapDemo {
    public static void main(String[] args) {

        // Create a hash map.
        HashMap<String, Double> hashMap = new HashMap<>();
        HashMap<String, Double> hashMap2 = new HashMap<>(10);
        HashMap<String, Double> hashMap3 = new HashMap<>(hashMap);
        HashMap<String, Double> hashMap4 = new HashMap<>(10, 0.8f);

        // Put elements to the map.
        hashMap.put("John Doe", 3434.34);
        hashMap.put("Tom Smith", 123.22);
        hashMap.put("Jane Baker", 1378.00);
        hashMap.put("Tod Hall", 99.22);
        hashMap.put("Ralph Smith", -19.08);

        // Get a set of the entries
        Set<Map.Entry<String, Double>> set = hashMap.entrySet();

        // Display the set.
        for (Map.Entry<String, Double> map : set) {
            System.out.print(map.getKey() + ": ");
            System.out.println(map.getValue());
        }

        System.out.println();

        // Deposit 1000 into John Doe account.
        double balance = hashMap.get("John Doe");
        hashMap.put("John Doe", balance + 1000);
        System.out.println("John Doe's new balance: " + hashMap.get("John Doe"));

        System.out.println();

        // check existence of key Tom Smith
        System.out.println("Check if key \"Tom Smith\" exists: " + hashMap.containsKey("Tom Smith"));

        // check existence of value 99.22
        System.out.println("Check if value \"99.22\" exists: " + hashMap.containsValue(99.22));

        // check if map is empty
        System.out.println("Hash map is empty: " + hashMap.isEmpty());

        // size of map.
        System.out.println("Hash map size: " + hashMap.size());

        // hash map values
        System.out.println("Hash map value: " + hashMap.values());
    }
}
