package com.paravar.labs.lab2.part2;

public class Q10 {
    public static void main(String[] args) {
        pattern(5);
    }
    public static void pattern(int height){
        for (int i = 1; i <= height; i++) {

            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }

           for (int j = 1; j <= i; j++) {
               System.out.print("* ");
           }
            System.out.println();
        }
    }
}
