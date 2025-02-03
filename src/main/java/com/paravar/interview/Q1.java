package com.paravar.interview;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args) {

        /*
        Given an integer array, print all repeating elements
        (Elements that appear more than once) in the array.
        The output should contain elements according to their first occurrences
        Input: arr[] = {12, 10, 9, 45, 2, 10, 10, 45}
        Output: 10 45
        Input: arr[] = {12, ,45, 10, 9, 45, 2, 10, 10, 45}
        Output: 45 10
        Note: You can use collection but don't use stream API
        *
        * */

        printDuplicates(12, 45, 10, 9, 45, 2, 10, 10, 45);
    }

    public static void printDuplicates(int... arr){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: arr){
            if(map.get(i)!=null){
                var val = map.get(i);
                if(val==1){
                    System.out.println(i);
                }
                map.put(i, val+1);
            }
            else {
                map.put(i, 1);
            }
        }
    }
}
