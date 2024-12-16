package com.paravar.labs.lab4;

public class Q1_TestArray {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        String[] arr2 = {"one","two","three","four", "five", "six", "seven", "eight", "nine", "ten"}; // length 10

        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 4;
        arr1[4] = 5;
        arr1[5] = 6;
        arr1[6] = 7;
        arr1[7] = 8;
        arr1[8] = 9;
        arr1[9] = 10;



        for(int i = 0 ; i < arr1.length ; i++)
            System.out.println("int at pos "+i+" = "+arr1[i]);

        for(String x : arr2)
            System.out.println(x);


    }
}
