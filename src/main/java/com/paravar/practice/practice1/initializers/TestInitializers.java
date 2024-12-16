package com.paravar.practice.practice1.initializers;

public class TestInitializers {

    static {
        System.out.println("TestInitializers - static initializer");
    }

    public static void main(String[] args) {

         // main static initializer
        X x = new X(); // x static initializer... then x instance initializer

        Y y = new Y(); //  then y static initializer...,x instance initializer(parent) then y instance initializer
        System.out.println(x+ " " + y);

    }
}

class X {
    static {
        System.out.println("X - static initializer");
    }

    {
        System.out.println(" X - instance initializer");
    }
}

class Y extends X {
    static {
        System.out.println("Y - static initializer");
    }

    {
        System.out.println("Y - instance initializer");
    }
}