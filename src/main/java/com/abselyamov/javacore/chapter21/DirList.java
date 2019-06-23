package com.abselyamov.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Display a directory.
 */
public class DirList {
    public static void main(String[] args) {
        String dirName = "src/main/java/com/abselyamov/javacore/chapter21/";

        // Obtain and manage a directory stream within a try block.
        try (DirectoryStream<Path> dirStrm = Files.newDirectoryStream(Paths.get(dirName))) {
            System.out.println("Directory of: " + dirName);

            // Because DirectoryStream implements Iterable, we
            // can use a "foreach" loop to display the directory.
            for (Path entry : dirStrm) {
                BasicFileAttributes attributes =
                        Files.readAttributes(entry, BasicFileAttributes.class);

                if (attributes.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("    ");

                System.out.println(entry.getName(7));
            }
        } catch (InvalidPathException e) {
            System.out.println("Path Error: " + e);
        } catch (NotDirectoryException e) {
            System.out.println(dirName + " is not a directory.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
