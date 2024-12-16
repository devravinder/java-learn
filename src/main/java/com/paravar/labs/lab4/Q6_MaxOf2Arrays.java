package com.paravar.labs.lab4;

public class Q6_MaxOf2Arrays {
    public static void main(String[] args) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {6, 7, 8, 9, 10};
        System.out.println(maxOf2Arrays(first, second));
    }

    public static int maxOf2Arrays( int[] first, int[] second) {
        int firstMax = maxOfArry(first);
        int secondMax = maxOfArry(second);
        return firstMax > secondMax ? firstMax : secondMax;
    }

    public static int maxOfArry(int[] arr){

        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
