package com.abselyamov.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * A simple example that uses walkFileTree( ) to display a directory tree.
 */

// Create a custom version of SimpleFileVisitor that overrides
// the visitFile( ) method.
class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

public class DirTreeList {
    public static void main(String[] args) {
        String dirName = "src/main/java/com/abselyamov/javacore/chapter21/";

        System.out.println("Directory tree starting with " + dirName + ":\n");

        try {
            Files.walkFileTree(Paths.get(dirName), new MyFileVisitor());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
