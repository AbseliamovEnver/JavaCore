package com.abselyamov.javacore.chapter21;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * Demonstrate NIO-based, stream output.
 */
public class NIOStreamWrite {
    public static void main(String[] args) {
        String path = "src/main/java/com/abselyamov/javacore/chapter21/resources/";
        // Open the file and obtain a stream linked to it.
        try (OutputStream fout =
                     new BufferedOutputStream(
                             Files.newOutputStream(Paths.get(path + "NIOStreamWrite.txt")))) {
            // Write some bytes to the stream.
            for (int i = 0; i < 26; i++)
                fout.write((byte) ('A' + i));
        } catch (InvalidPathException e) {
            System.out.println("Path Error: " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
