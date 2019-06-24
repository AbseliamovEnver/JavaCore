package com.abselyamov.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Use collect() to create a List and a Set from a stream.
 */
class NamePhoneEmail1 {
    String name;
    String phone;
    String email;

    public NamePhoneEmail1(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

class NameAndPhone1 {
    String name;
    String phone;

    public NameAndPhone1(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class StreamDemo7 {
    public static void main(String[] args) {
        // A list of names, phone numbers, and e-mail addresses.
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "555-5555",
                "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("James", "555-4444",
                "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333",
                "Mary@HerbSchildt.com"));

        // Map just the names and phone numbers to a new stream.
        Stream<NameAndPhone1> nameAndPhone1 = myList.stream().map(
                a -> new NameAndPhone1(a.name, a.phone));

        // Use collect to create a List of the names and phone numbers.
        List<NameAndPhone1> npList = nameAndPhone1.collect(Collectors.toList());

        System.out.println("Names and phone numbers in a List:");
        for (NameAndPhone1 namePhone : npList)
            System.out.println(namePhone.name + ": " + namePhone.phone);

        // Obtain another mapping of the names and phone numbers.
        nameAndPhone1 = myList.stream().map(a -> new NameAndPhone1(a.name, a.phone));

        // Now, create a Set by use of collect().
        Set<NameAndPhone1> npSet = nameAndPhone1.collect(Collectors.toSet());

        System.out.println("\nNames and phone numbers in a Set:");
        for (NameAndPhone1 e : npSet)
            System.out.println(e.name + ": " + e.phone);
    }
}
