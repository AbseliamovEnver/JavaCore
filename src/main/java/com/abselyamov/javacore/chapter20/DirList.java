package com.abselyamov.javacore.chapter20;

import java.io.File;

/**
 * Using directories.
 */
public class DirList {
    public static void main(String[] args) {
        String dirName = "src/main/java/com/abselyamov/javacore/chapter20/";
        File f1 = new File(dirName);

        if (f1.isDirectory()) {
            System.out.println("Directory of " + dirName);
            String[] s = f1.list();

            for (int i = 0; i < s.length; i++) {
                File f = new File(dirName + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " is a directory");
                } else {
                    System.out.println(s[i] + " is a file");
                }
            }
        } else {
            System.out.println(dirName + " is not a directory");
        }
    }
}
