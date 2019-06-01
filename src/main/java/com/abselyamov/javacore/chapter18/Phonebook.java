package com.abselyamov.javacore.chapter18;

import java.io.*;
import java.util.Properties;

/**
 * @author Enver on 01.06.2019 15:43.
 * @project javacore
 * <p>
 * A simple telephone number database that uses a property list.
 */
public class Phonebook {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = null;

        String name, number;
        boolean changed = false;

        // Try to open phonebook.dat file.
        try {
            fin = new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {
            // ignore missing file...
        }

        // If phonebook file already exists, load existing telephone numbers.
        try {
            if (fin != null)
                prop.load(fin);
            fin.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        // Let user enter new names and numbers.
        do {
            System.out.println("Enter new name ('quit' to stop): ");
            name = bufRead.readLine();

            if (name.equalsIgnoreCase("quit"))
                continue;

            System.out.println("Enter number: ");
            number = bufRead.readLine();

            prop.put(name, number);
            changed = true;
        } while (!name.equals("quit"));

        // If phone book data has changed, save it.
        if (changed) {
            FileOutputStream fout = new FileOutputStream("phonebook.dat");

            prop.store(fout, "Telephone Book");
            fout.close();
        }

        // Look up numbers given a name.
        do {
            System.out.println("Enter name to fine ('quit' to quit): ");

            name = bufRead.readLine();
            if (name.equals("quit"))
                continue;

            number = (String) prop.get(name);
            System.out.println(number);
        } while (!name.equals("quit"));
    }
}
