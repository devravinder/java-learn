package com.paravar.labs.lab2;

public class Q10 {
    public static void main(String[] args) {
        System.out.println(1==1 ? 5 : 6);
        System.out.println(1==2 ? 5 : 6);
        System.out.println(1==1 ? true : false);
        System.out.println(1==2 ? false : true);


        System.out.println( true ? false : true);
        System.out.println( true ? true: false);
        char x = 'X';
        int i=0;
        System.out.println(true ? x : 0); // here '0' is treated as char, so both are chars then result is char
        System.out.println(false ? i : x);// one is int another is char, so char is upcasted to int
    }
}
