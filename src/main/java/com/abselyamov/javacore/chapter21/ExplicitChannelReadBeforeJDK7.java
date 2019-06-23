package com.abselyamov.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Use Channels to read a file. Pre-JDK 7 version.
 */
public class ExplicitChannelReadBeforeJDK7 {
    public static void main(String args[]) {
        FileInputStream fIn = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;
        String path = "src/main/java/com/abselyamov/javacore/chapter21/resources/";

        try {
            // First, open a file for input.
            fIn = new FileInputStream(path + "ExplicitChannelReadBeforeJDK7.txt");

            // Next, obtain a channel to that file.
            fChan = fIn.getChannel();

            // Allocate a buffer.
            mBuf = ByteBuffer.allocate(128);

            do {
                // Read a buffer.
                count = fChan.read(mBuf);

                // Stop when end of file is reached.
                if (count != -1) {

                    // Rewind the buffer so that it can be read.
                    mBuf.rewind();

                    // Read bytes from the buffer and show
                    // them on the screen.
                    for (int i = 0; i < count; i++)
                        System.out.print((char) mBuf.get());
                }
            } while (count != -1);

            System.out.println();

        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        } finally {
            try {
                if (fChan != null) fChan.close(); // close channel
            } catch (IOException e) {
                System.out.println("Error Closing Channel.");
            }
            try {
                if (fIn != null) fIn.close(); // close file
            } catch (IOException e) {
                System.out.println("Error Closing File.");
            }
        }
    }
}
