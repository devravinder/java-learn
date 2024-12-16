package com.paravar.labs.lab4;

public class Q14_ReverseString {
    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println("Method1");
        System.out.println(reverseStringMethod1(str));
        System.out.println("Method2");
        System.out.println(reverseStringMethod2(str));
        System.out.println("Method3");
        System.out.println(reverseStringMethod3(str));

    }
    public static String reverseStringMethod1(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public static String reverseStringMethod2(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseStringMethod3(String str){

        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length/2; i++) {
            swapChars(chars, i, chars.length - 1 - i);
        }
        // swap chars
        return new String(chars);
    }

    public static void swapChars(char[] chars, int i, int j){
        // we can do it in 3 ways

        // using ^ operator
        chars[i] =(char) (chars[i] ^ chars[j]);
        chars[j] =(char) (chars[i] ^ chars[j]);
        chars[i] =(char) (chars[i] ^ chars[j]);

    }

}
