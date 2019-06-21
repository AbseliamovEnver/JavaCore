package com.abselyamov.javacore.chapter20;

import java.io.*;

/**
 * Demonstrate DataInputStream and DataOutputStream.
 */
public class DataIODemo {
    public static void main(String[] args) {
        String path = "src/main/java/com/abselyamov/javacore/chapter20/resources/";

        // First, write the data.
        try (DataOutputStream dout =
                     new DataOutputStream(new FileOutputStream(path + "DataIO.txt"))) {
            dout.writeDouble(56.4);
            dout.writeInt(2568);
            dout.writeBoolean(true);

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open output file");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        // Now, read the data back.
        try (DataInputStream din =
                     new DataInputStream(new FileInputStream(path + "DataIO.txt"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("Here are the values: " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open input file.");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error" + e);
        }
    }
}
