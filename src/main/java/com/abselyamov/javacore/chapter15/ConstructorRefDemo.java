package com.abselyamov.javacore.chapter15;

/**
 * Demonstrate a Constructor reference.
 */
// MyFunc is a functional interface whose method returns
// a MyClass reference.
interface MyFunc3 {
    MyClass1 func(int n);
}

class MyClass1 {
    private int val;

    // This constructor takes an argument.

    public MyClass1(int v) {
        this.val = v;
    }

    public MyClass1() {
        val = 0;
    }

    public int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        // Create a reference to the MyClass1 constructor.
        // Because func() in MyFunc3 takes an argument, new
        // refers to the parameterized constructor in MyClass1,
        // not the default constructor.
        MyFunc3 myClassCons = MyClass1::new;

        // Create an instance of MyClass1 via that constructor reference.
        MyClass1 mc = myClassCons.func(100);

        // Use the instance of MyClass1 just created.
        System.out.println("val in mc is " + mc.getVal());
    }
}
