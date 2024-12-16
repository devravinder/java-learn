package com.paravar.labs.lab6;

public class Q2_TestInitialization {
}
class X {
    int a=10;
    static int b=15;

    static {
        System.out.println("static block-1 b="+b);
        b=25;
    }
    {
        System.out.println("instance block-1 a="+a);
        a=20;
    }
    {
        System.out.println("instance block-2 a="+a);
        a=30;
    }

    static {
        System.out.println("static block-2 b="+b);
        b=45;
    }

    public X(){
        System.out.println("constructor a="+a);
        a=50;
    }

    public X(int a) {
        System.out.println("in X constructor a="+a);
        this.a = a;
    }
}
class Y extends X {
    int c =10;
    static int d =15;

    static {
        System.out.println("static block-1 d="+ d);
        d =25;
    }
    {
        System.out.println("instance block-1 c="+ c);
        c =20;
    }
    {
        System.out.println("instance block-2 c="+ c);
        c =30;
    }

    static {
        System.out.println("static block-2 d="+ d);
        d =45;
    }

    public Y(){
        System.out.println("constructor c="+ c);
        c =50;
    }

    public Y(int c) {
        //super(c);
        System.out.println("in Y constructor c="+ c);
        this.c = c;
    }
}