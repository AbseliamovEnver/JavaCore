package com.abselyamov.javacore.chapter21;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Write to a mapped file. Pre JDK 7 version.
 */
public class MappedChannelWriteBeforeJDK7 {
    public static void main(String[] args) {
        RandomAccessFile fOut = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        String path = "src/main/java/com/abselyamov/javacore/chapter21/resources/";

        try {
            fOut = new RandomAccessFile(path + "MappedChannelWriteBeforeJDK7.txt", "rw");

            // Next, obtain a channel to that file.
            fChan = fOut.getChannel();

            // Then, map the file into a buffer.
            mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            // Write some bytes to the buffer.
            for (int i = 0; i < 26; i++)
                mBuf.put((byte) ('A' + i));

        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        } finally {
            try {
                if (fChan != null) fChan.close(); // close channel
            } catch (IOException e) {
                System.out.println("Error Closing Channel.");
            }
            try {
                if (fOut != null) fOut.close(); // close file
            } catch (IOException e) {
                System.out.println("Error Closing File.");
            }
        }
    }
}
