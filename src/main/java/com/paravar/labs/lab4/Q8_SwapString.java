package com.paravar.labs.lab4;

public class Q8_SwapString {
    public static void main(String[] args) {

        System.out.println(swapString("abcdef"));
    }
    public static String swapString(String str){
        return str.charAt(str.length()-1) + str.substring(1, str.length()-1)+ str.charAt(0);
    }
}
