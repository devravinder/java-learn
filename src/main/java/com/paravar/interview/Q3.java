package com.paravar.interview;

import java.util.Arrays;
import java.util.Comparator;

public class Q3 {
    public static void main(String[] args) {

        bubbleSort(2,3,4,1,6,5);

    }

    public static void bubbleSort(int... arr){

        boolean swapped = false;
        for(int i=0; i<arr.length; i++){

            for(int j=0; j< arr.length-1-i; j++){

                if(arr[j]>arr[j+1]){
                    swap(j, j+1, arr);
                    swapped = true;
                }
            }

            if(!swapped)
                break;

        }

        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int i, int j, int[] arr){
        int t = arr[i];
         arr[i] = arr[j];
         arr[j] = t;
    }

}


class Emp {
    String name;
    String age;
}


class EmpComparator implements Comparator<Emp>{

    @Override
    public int compare(Emp o1, Emp o2) {
        return o1.name.compareTo(o2.name);
    }
}