package com.paravar.labs.lab2.part2;

public class Q8 {
    public static void main(String[] args) {
        shamboGovina(5);
        shamboGovina(6);
    }
    public static void shamboGovina(int times){
        String text = isEven(times) ? "Shambo" : "Govina";
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }

    }

    public static boolean isEven(int n){
        return (n & 1) == 0;
    }
}
