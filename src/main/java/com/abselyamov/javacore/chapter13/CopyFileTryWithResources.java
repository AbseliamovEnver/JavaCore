package com.abselyamov.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A version of CopyFile that uses try-with-resources.
 * It demonstrates two resources (in this case files) being
 * managed by a single try statement.
 * java CopyFile ReadFile.txt, WriteFile.txt
 * args -> $FileDir$\resources\ReadFile.txt $FileDir$\resources\WriteFile.txt
 */
public class CopyFileTryWithResources {
    public static void main(String[] args) {
        int i;

        // First, confirm that both files have been specified.
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from ReadFile.txt to WriteFile.txt");
            return;
        }

        // Open and manage two files via the try statement.
        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])) {
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
