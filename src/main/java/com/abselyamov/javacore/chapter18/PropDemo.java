package com.abselyamov.javacore.chapter18;

import java.util.Properties;
import java.util.Set;

/**
 * @author Enver on 01.06.2019 14:32.
 * @project javacore
 * <p>
 * Properties is a subclass of Hashtable.
 * Demonstrate a Property list.
 */
public class PropDemo {
    public static void main(String[] args) {
        Properties capitals = new Properties();

        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        // Get a set-view of the keys.
        Set<?> set = capitals.keySet();

        // Show all of the state and capitals.
        for (Object name : set)
            System.out.println("The capital of " + name + " is " + capitals.getProperty((String) name) + ".");
        System.out.println();

        // Look for state not in list -- specify default.
        String def = capitals.getProperty("Florida", "Not found");
        System.out.println("The capital of Florida is " + def + ".");
    }
}
