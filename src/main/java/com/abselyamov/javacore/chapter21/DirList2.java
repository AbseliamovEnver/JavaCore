package com.abselyamov.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Display a directory of only those files that are writable.
 */
public class DirList2 {
    public static void main(String[] args) {
        String dirName = "src/main/java/com/abselyamov/javacore/chapter21/";

        // Create a filter that returns true only for writable files.
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                if (Files.isWritable(entry))
                    return true;
                return false;
            }
        };

        // Obtain and manage a directory stream of writable files.
        try (DirectoryStream<Path> dirStrm =
                     Files.newDirectoryStream(Paths.get(dirName), how)) {
            System.out.println("Directory of: " + dirName);

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
