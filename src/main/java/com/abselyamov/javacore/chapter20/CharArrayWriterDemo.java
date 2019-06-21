package com.abselyamov.javacore.chapter20;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrate CharArrayWriter
 */
public class CharArrayWriterDemo {
    public static void main(String[] args) {
        String path = "src/main/java/com/abselyamov/javacore/chapter20/resources/";
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        String str = "This should end up in the array.";
        char[] buf = new char[str.length()];

        str.getChars(0, str.length(), buf, 0);

        try {
            charArrayWriter.write(buf);
        } catch (IOException e) {
            System.out.println("Error writing to buffer");
            return;
        }

        System.out.println("Buffer as a string:");
        System.out.println(charArrayWriter.toString());

        System.out.println("Into array");
        char[] chars = charArrayWriter.toCharArray();
        for (int i = 0; i < chars.length; i++)
            System.out.print(chars[i]);

        System.out.println("\nTo a FileWriter()");

        try (FileWriter fileWriter = new FileWriter(path + "CharArrayWriter.txt")) {
            charArrayWriter.writeTo(fileWriter);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        System.out.println("Doing a reset.");
        charArrayWriter.reset();

        for (int i = 0; i < 3; i++)
            charArrayWriter.write('X');
        System.out.println(charArrayWriter.toString());
    }
}
