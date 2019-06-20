package com.abselyamov.javacore.chapter20;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Demonstrate FileOutputStream.
 * This program uses the traditional approach to closing a file.
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        byte[] buf = source.getBytes();
        FileOutputStream f0 = null;
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;

        String path = "src/main/java/com/abselyamov/javacore/chapter20/resources/";
        try {
            f0 = new FileOutputStream(path + "file1.txt");
            f1 = new FileOutputStream(path + "file2.txt");
            f2 = new FileOutputStream(path + "file3.txt");

            // write to first file
            for (int i = 0; i < buf.length; i += 2)
                f0.write(buf[i]);

            // write to second file
            f1.write(buf);

            // write to third file
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        } finally {
            try {
                if (f0 != null)
                    f0.close();
            } catch (IOException e) {
                System.out.println("Error Closing file1.txt");
            }
            try {
                if (f1 != null)
                    f1.close();
            } catch (IOException e) {
                System.out.println("Error Closing file2.txt");
            }
            try {
                if (f2 != null)
                    f2.close();
            } catch (IOException e) {
                System.out.println("Error Closing file3.txt");
            }
        }
    }
}
