package com.paravar.labs.lab4;

public class Q11_SecondBiggestOfArray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        // manually compare firts 2 elememnts
        int max = arr[0] > arr[1] ? arr[0] : arr[1];
        int secondMax = arr[0] > arr[1] ? arr[1] : arr[2];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println(secondMax);
    }
}
