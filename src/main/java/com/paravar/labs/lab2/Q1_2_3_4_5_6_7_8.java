package com.paravar.labs.lab2;

public class Q1_2_3_4_5_6_7_8 {
    public static void main(String[] args) {

        // Q1
        int a = 012; // octal
        System.out.println("octal: "+a);

        int b = 0x12; // hexadecimal
        System.out.println("hexadecimal: "+b);

        int c = 0b1010; // binary
        System.out.println("binary: "+c);

        // Q2

        int d = 1 + 1;
        double f = 1.0 + 1.0;

        System.out.println("sum of int and int: "+d+" and double and double: "+f);

        // Q3

        char ch1 = 'a';
        char ch2 = 100; // a=97, b=98, c=99, d=100
        System.out.println("ch1: "+ch1+" ch2: "+ch2);

        // Q4
        byte b1 = 4;
        short s1 = 5;
        // short s2 = s1 + b1; // error
        short s2 = (short)(s1 + b1);
        System.out.println("short s2: "+s2);


        // Q5
        long maxValue = -1L >>> 1;
        System.out.println("long max value: "+maxValue);
        float f1 = maxValue; //  stores exponential notation
        System.out.println("float value: "+f1); // 9.223372E18 = 9.223372* 10^18

        // Q6
        int i1 = 10;
        int i2 = 11;
        int sub1 = i1-i2;
        System.out.println("sub: "+sub1);

        // Q7
        int i3 = 10;
        int i4 = 11;
        int mul1 = i3*i4;
        System.out.println("mul: "+mul1);

        double d1 = 10.0;
        double d2 = 11.0;
        double mul2 = d1*d2;
        System.out.println("mul2: "+mul2);

        // Q8

        int i5 = 20;
        int i6 = 11;
        int quotient = i5/i6;
        int remainder = i5 % i6;
        System.out.println("quotient: "+quotient+" remainder: "+remainder);



    }
}
