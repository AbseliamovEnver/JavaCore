package com.abselyamov.javacore.chapter20;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Directory of .txt files.
 */
class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

public class DirListOnly {
    public static void main(String[] args) {
        String dirName = "src/main/java/com/abselyamov/javacore/chapter20/resources";
        File f1 = new File(dirName);
        FilenameFilter only = new OnlyExt("txt");
        String[] s = f1.list(only);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
