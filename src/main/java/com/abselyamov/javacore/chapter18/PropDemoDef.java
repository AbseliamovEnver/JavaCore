package com.abselyamov.javacore.chapter18;

import java.util.Properties;
import java.util.Set;

/**
 * @author Enver on 01.06.2019 14:48.
 * @project javacore
 */
public class PropDemoDef {
    public static void main(String[] args) {
        Properties defList = new Properties();

        defList.put("Florida", "Tallahassee");
        defList.put("Wisconsin", "Madison");

        Properties capitals = new Properties(defList);
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

        // Florida will now be found in the default list.
        String def = capitals.getProperty("Florida");
        System.out.println("The capital of Florida " + def + ".");
    }
}
