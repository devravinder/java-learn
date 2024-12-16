package com.paravar.labs.lab4;

public class Q18_ReverseCase {
    public static void main(String[] args) {
        System.out.println(reverseCase("aBc%12x"));
    }
    public static String reverseCase(String str) {
        // input: aBc%12x output: AbC%12X

        StringBuilder sb = new StringBuilder();
        for( char ch: str.toCharArray()){
            if(Character.isAlphabetic(ch))
            {
                if(Character.isUpperCase(ch))
                    sb.append(Character.toLowerCase(ch));
                else
                    sb.append(Character.toUpperCase(ch));
            }
            else
            {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
