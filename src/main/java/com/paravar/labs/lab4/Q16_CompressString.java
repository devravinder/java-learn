package com.paravar.labs.lab4;

public class Q16_CompressString {
    public static void main(String[] args) {

        String str = "aabcccccaaamnnnnp";
        String compressed = compressString(str);
        System.out.println(compressed);
    }
    public static String compressString(String str){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            count++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString();
    }
}
