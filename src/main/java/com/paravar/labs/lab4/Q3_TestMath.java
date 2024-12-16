package com.paravar.labs.lab4;

public class Q3_TestMath {
    public static void main(String[] args) {

        double x = 81;
        double res = Math.sqrt(x);
        System.out.println("sqrt of "+x+" = "+res);
        res = Math.cbrt(x);
        System.out.println("cbrt of "+x+" = "+res);
        res = Math.random();
        System.out.println("random = "+res);
        res = Math.pow(2, 3);
        System.out.println("2^3 = "+res);

        System.out.println(add(2,3));
        int[] arr = {1,2,3};
        System.out.println(sumOfArray(arr));
        System.out.println(addDoubles(2.0,3.0));

        Complex a = new Complex();
        a.real = 1;
        a.imaginary = 2;
        Complex b = new Complex();
        b.real = 3;
        b.imaginary = 4;
        Complex c = addComplex(a,b);
        System.out.println(c.real+"+"+c.imaginary+"i");

    }

    public static int add(int a, int b){
        return  a+b;
    }
    public static int sumOfArray(int[] arr){
        int sum = 0;
        for(int i: arr)
            sum += i;
        return sum;
    }
    public static double addDoubles(double a, double b){
        return  a+b;
    }
    public static Complex addComplex(Complex a, Complex b){
        Complex c = new Complex();
        c.real = a.real + b.real;
        c.imaginary = a.imaginary + b.imaginary;
        return c;
    }
}

class Complex {
    int real;
    int imaginary;
}
