package com.paravar.labs.lab4;

public class Q9_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
    }
    public static boolean isPalindrome(String str){
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
