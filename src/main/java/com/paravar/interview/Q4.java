package com.paravar.interview;

public class Q4 {

    public static void main(String[] args) {

        Multi multi = (a,b)->a*b;

        int res = multi.multiple(1,2);

        System.out.println(res);

        System.out.println("=============");

    }

}


@FunctionalInterface
interface Multi{
    int multiple(int a, int b);
}