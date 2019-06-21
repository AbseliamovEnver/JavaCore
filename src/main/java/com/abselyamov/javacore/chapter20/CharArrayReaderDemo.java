package com.abselyamov.javacore.chapter20;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * Demonstrate CharArrayReaderDemo.
 */
public class CharArrayReaderDemo {
    public static void main(String[] args) {
        String source = "abcdefghijklmnopqrstuvwxyz";
        int length = source.length();
        char[] chars = new char[length];

        source.getChars(0, length, chars, 0);
        int i;

        try (CharArrayReader inpit1 = new CharArrayReader(chars)) {
            System.out.println("input1 is:");
            while ((i = inpit1.read()) != -1)
                System.out.print((char) i);
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        try (CharArrayReader input2 = new CharArrayReader(chars, 0, 5)) {
            System.out.println("input2 is:");
            while ((i = input2.read()) != -1)
                System.out.print((char) i);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
