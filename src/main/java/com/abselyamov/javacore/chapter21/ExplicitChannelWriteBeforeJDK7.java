package com.abselyamov.javacore.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Write to a file using NIO. Pre-JDK 7 Version.
 */
public class ExplicitChannelWriteBeforeJDK7 {
    public static void main(String args[]) {
        FileOutputStream fOut = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        String path = "src/main/java/com/abselyamov/javacore/chapter21/resources/";

        try {
            // First, open the output file.
            fOut = new FileOutputStream(path + "ExplicitChannelWriteBeforeJDK7.txt");

            // Next, get a channel to the output file.
            fChan = fOut.getChannel();

            // Create a buffer.
            mBuf = ByteBuffer.allocate(26);

            // Write some bytes to the buffer.
            for (int i = 0; i < 26; i++)
                mBuf.put((byte) ('A' + i));

            // Rewind the buffer so that it can be written.
            mBuf.rewind();

            // Write the buffer to the output file.
            fChan.write(mBuf);
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
