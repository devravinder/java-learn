package com.paravar.labs.lab2.part2;

public class Q3_4 {
    public static void main(String[] args) {
        printTable(5);
        System.out.println("============");
        printTableRange(2, 5);

    }
    public static void printTable(int num){
        for(int j=1; j<=10; j++) {
            System.out.println(num + " * " + j + " = " + num * j);
        }
    }

    public static void printTableRange(int first, int second){
        int small = first<second ? first : second;
        int large = first<second ? second : first;
        for(int i=1; i<=large; i++) {
            System.out.println(small + " * " + i + " = " + small * i);
        }
    }
}
