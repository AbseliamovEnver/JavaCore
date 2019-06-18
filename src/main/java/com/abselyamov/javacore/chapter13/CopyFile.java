package com.abselyamov.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Copy a file.
 * To use this program, specify the name of the source file and the destination file.
 * For example, to copy a file called ReadFile.txt to a file called WriteFile.txt, use the following
 * command line.
 * java CopyFile ReadFile.txt, WriteFile.txt
 * args -> $FileDir$\resources\ReadFile.txt $FileDir$\resources\WriteFile.txt
 */
public class CopyFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        // First, confirm that both files have been specified.
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from ReadFile.txt to WriteFile.txt");
            return;
        }

        // Copy a File.
        try {
            // Attempt to open the files.
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e2) {
                System.out.println("Error Closing Input File");
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e3) {
                System.out.println("Error Closing Output File");
            }
        }
    }
}
