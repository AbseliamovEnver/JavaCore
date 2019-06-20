package com.abselyamov.javacore.chapter15;

/**
 * Demonstrate a constructor reference with a generic class.
 */
// MyFunc4 is now a generic functional interface.
interface MyFunc4<T> {
    MyClass2<T> func(T n);
}

class MyClass2<T> {
    private T val;

    // A constructor that takes an argument.
    public MyClass2(T v) {
        this.val = v;
    }

    // This is the default constructor.
    public MyClass2() {
        val = null;
    }

    public T getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        // Create a reference to the MyClass2<T> constructor.
        MyFunc4<Integer> myClassCons = MyClass2<Integer>::new;

        // Create an instance of MyClass2<T> via that constructor reference.
        MyClass2<Integer> mc = myClassCons.func(100);

        // Use the instance of MyClass2<T> just created.
        System.out.println("val in mc is " + mc.getVal());
    }
}
