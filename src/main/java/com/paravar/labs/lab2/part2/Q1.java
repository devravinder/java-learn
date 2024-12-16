package com.paravar.labs.lab2.part2;

public class Q1 {
    public static void main(String[] args) {

        int x = 50;
        System.out.println(x);
        process(x);
        System.out.println(x);


    }
    static void process (int x){
        System.out.println("=========== in process before changing "+ x);
        x = 20;
        System.out.println("=========== in process after changing "+ x);
    }

}
