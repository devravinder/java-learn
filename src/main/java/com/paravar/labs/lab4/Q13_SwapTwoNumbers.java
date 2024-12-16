package com.paravar.labs.lab4;

public class Q13_SwapTwoNumbers {
    public static void main(String[] args) {

        System.out.println("Method1");
        swapMethod1(1, 2);
        System.out.println("Method2");
        swapMethod2(1, 2);
        System.out.println("Method3");
        swapMethod3(1, 2);

    }
    public static void swapMethod1(int a, int b){
        System.out.println("before swap: a = "+a+" b = "+b);
        int temp = a;
        a = b;
        b = temp;

        System.out.println("after swap: a = "+a+" b = "+b);
    }
    public static void swapMethod2(int a, int b){
        System.out.println("before swap: a = "+a+" b = "+b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("after swap: a = "+a+" b = "+b);
    }
    public static void swapMethod3(int a, int b){
        System.out.println("before swap: a = "+a+" b = "+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("after swap: a = "+a+" b = "+b);
    }
}
