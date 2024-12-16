package com.paravar.labs.lab5;

public class Q2_TestInitializer {

    public static void main(String[] args) {

        X x1 = new X();
        System.out.println("a="+x1.a);
        System.out.println("b="+X.b);

        System.out.println("===");
        X x2 = new X();
        System.out.println("a="+x2.a);
        System.out.println("b="+X.b);
    }
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
        // b=35; // un-comment and see
    }

    static {
        System.out.println("static block-2 b="+b);
        b=45;
        // a=40 // un-comment and see // error
    }

    public X(){
        System.out.println("constructor a="+a);
        a=50;
    }

}