package com.paravar.labs.lab4;

public class Q17_UniCodeString {
    public static void main(String[] args) {
        System.out.println("Unicode of abc "+uniCodeString("abc"));
    }

    public static String uniCodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for( char ch: s.toCharArray()){
            int code = (int) ch;
            sb.append(code+".");
        }
        return sb.substring(0, sb.length()-1);
    }
}
