package com.paravar.labs.lab2.part2;

public class Q7 {
    public static void main(String[] args) {
        pattern(5);

    }
     public static  void pattern(int height){
        for (int k = 1; k <= height; k++) { // height number of times(lines)
            for (int j = 1; j <= k; j++) { // k number of times
                System.out.print(j);
            }
            System.out.println(); // for new line
        }
    }
}
