package com.abselyamov.javacore.chapter18;

import java.util.ArrayDeque;

/**
 * @author Enver on 30.05.2019 18:16.
 * @project javacore
 *
 * class ArrayDeque<E> extends AbstractCollection implements Deque.
 */
public class ArrayDequeDemo {
    public static void main(String[] args) {
        // Create an array deque.
        ArrayDeque<String> arrayDeque = new ArrayDeque();
        ArrayDeque<String> arrayDeque2 = new ArrayDeque(50);
        ArrayDeque<String> arrayDeque3 = new ArrayDeque(arrayDeque);

        // Use an ArrayDeque like a stack.
        arrayDeque.push("A");
        arrayDeque.push("B");
        arrayDeque.push("C");
        arrayDeque.push("D");
        arrayDeque.push("E");
        arrayDeque.push("F");

        System.out.print("Popping the stack: ");

        while(arrayDeque.peek() != null){
            System.out.print(arrayDeque.pop() + " ");
        }

        System.out.println();
    }
}
