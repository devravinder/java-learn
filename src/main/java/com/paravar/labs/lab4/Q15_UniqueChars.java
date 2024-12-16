package com.paravar.labs.lab4;

public class Q15_UniqueChars {
    public static void main(String[] args) {

        String str = "Hello World";
        String unique = "";
        for (int i = 0; i < str.length(); i++) {
            if (unique.indexOf(str.charAt(i)) == -1) {
                unique += str.charAt(i);
            }
        }
        System.out.println(unique);
    }
}
