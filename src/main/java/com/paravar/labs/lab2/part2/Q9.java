package com.paravar.labs.lab2.part2;

public class Q9 {
    public static void main(String[] args) {
        pattern(7);
    }

    private static void pattern(int i) {
        for (int j = i; j >=0; j--) {
            for (int k = 1; k <= j; k++) {
                System.out.print(k);
            }
            System.out.println();
        }

    }
}
