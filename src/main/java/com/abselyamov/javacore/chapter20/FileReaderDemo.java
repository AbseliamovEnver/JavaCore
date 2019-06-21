package com.abselyamov.javacore.chapter20;

import java.io.FileReader;
import java.io.IOException;

/**
 * Demonstrate FileReader.
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        String path = "src/main/java/com/abselyamov/javacore/chapter20/resources/";
        try (FileReader fr = new FileReader(path + "FileReader.txt")) {
            int c;

            // Read and display the file.
            while ((c = fr.read()) != -1)
                System.out.print((char) c);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
