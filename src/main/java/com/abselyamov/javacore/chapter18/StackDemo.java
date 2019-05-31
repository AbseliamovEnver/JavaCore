package com.abselyamov.javacore.chapter18;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Enver on 01.06.2019 2:17.
 * @project javacore
 * <p>
 * class Stack is a subclass of Vector
 * Demonstrate the Stack class.
 */
public class StackDemo {
    static void showPush(Stack<Integer> stack, int a) {
        stack.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + stack);
    }

    static void showPop(Stack<Integer> stack) {
        System.out.print("pop -> ");
        Integer a = stack.pop();
        System.out.println(a);
        System.out.println("stack: " + stack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("stack: " + stack);

        showPush(stack, 42);
        showPush(stack, 66);
        showPush(stack, 99);

        showPop(stack);
        showPop(stack);
        showPop(stack);

        try {
            showPop(stack);
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty.");
        }
    }
}
