package com.paravar.labs.lab4;

public class Q7_AvgOf2Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        System.out.println(avgOf2Arrays(arr1, arr2));

    }
    public static int sumOfArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    public static double avgOf2Arrays(int[] arr1, int[] arr2){
        return (sumOfArray(arr1) + sumOfArray(arr2)) / (arr1.length + arr2.length);
    }
}
