package com.paravar.labs.lab4;

public class Q10_NoOfWords {
    public static void main(String[] args) {
        System.out.println(noOfWords("Hello World"));
    }
    public static int noOfWords(String str){
        return str.split(" ").length;
    }
}
