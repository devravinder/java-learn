package com.paravar.labs.lab7;

public class Q6_TestInterface {
}

interface I1 {
    //public void m1();
}

interface I2 {
    public int m1();
    public void m2();
}

class C1 implements I1, I2 {


    public int m1() {
        System.out.println("C1.m1()");
        return 0;
    }
    // return type clash error
   /* public void m1(){
        System.out.println("in C1 - m1");
    }*/

    @Override
    public void m2() {
        System.out.println("in C1 - m2");
    }
}

abstract class C2 implements I2 {
    @Override
    public int m1() {
        System.out.println("in C2 - m1");
        return 0;
    }
}