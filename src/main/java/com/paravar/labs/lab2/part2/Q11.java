package com.paravar.labs.lab2.part2;

public class Q11 {
    public static void main(String[] args) {

        printCharecters();
    }
    public static void printCharecters(){
        for (int i = 0; i < 65535; i++) {
            if(i%5==0)
                continue;
            System.out.print((char)i);
            System.out.print(" ");
        }
    }
}
