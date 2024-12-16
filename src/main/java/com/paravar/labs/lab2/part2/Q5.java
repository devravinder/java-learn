package com.paravar.labs.lab2.part2;

public class Q5 {
    public static void main(String[] args) {

        skip11Multiples(100);

    }
    public static void skip11Multiples(int range){
        for(int i=1; i<=range; i++){
            if(i%11==0){
                System.out.println();
                continue;
            }
            System.out.print(i);
        }
    }
}
