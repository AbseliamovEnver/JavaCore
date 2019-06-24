package com.abselyamov.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * Use a Spliterator with a stream.
 */
public class StreamDemo9 {
    public static void main(String[] args) {
        // Create a list of Strings.
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Phi");
        myList.add("Omega");

        // Obtain a Stream to the array list.
        Stream<String> myStream = myList.stream();

        // Obtain a Spliterator to the stream.
        Spliterator<String> splitItr = myStream.spliterator();

        // Iterate the elements in the stream.
        while (splitItr.tryAdvance(n -> System.out.println(n))) ;
    }
}
