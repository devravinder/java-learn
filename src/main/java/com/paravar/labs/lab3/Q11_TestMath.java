package com.paravar.labs.lab3;

public class Q11_TestMath {
    public static void main(String[] args) {
        double result;
        result = Math.sqrt(4.0); // returns square root of value
        System.out.println(result);
        result = Math.cbrt(16.0); // returns cube root of value
        System.out.println(result);
        result = Math.pow(3,2); // returns power
        System.out.println(result);
        result = Math.floor(9.999); // take it to the floor - reduce to lower decimal
        System.out.println(result);
        result = Math.ceil(9.009); // take it to the ceiling - to the higher decimal
        System.out.println(result);
        result = Math.round(9.5);
        System.out.println(result);
        result = Math.round(9.49);
        System.out.println(result);
        result = Math.abs(+9.999);
        System.out.println(result);
        result = Math.abs(-9.999);
        System.out.println(result);
        result = Math.random(); // returns a random double value
        System.out.println(result);

    }
}
