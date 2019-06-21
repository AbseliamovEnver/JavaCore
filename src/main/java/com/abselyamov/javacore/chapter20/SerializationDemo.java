package com.abselyamov.javacore.chapter20;

import java.io.*;

/**
 * A Serialization demo
 */
public class SerializationDemo {
    public static void main(String[] args) {
        // Object serialization
        try (ObjectOutputStream objOStrm =
                     new ObjectOutputStream(new FileOutputStream("serial"))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("Object1: " + object1);

            objOStrm.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Exception during serialization: " + e);
        }

        // Object deserialization
        try (ObjectInputStream objIStrm =
                     new ObjectInputStream(new FileInputStream("serial"))) {
            MyClass object2 = (MyClass) objIStrm.readObject();
            System.out.println("Object2: " + object2);
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
        }
    }
}

class MyClass implements Serializable {
    String string;
    int i;
    transient double d;

    public MyClass(String string, int i, double d) {
        this.string = string;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "string='" + string + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}';
    }
}
