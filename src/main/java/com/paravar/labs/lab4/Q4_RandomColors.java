package com.paravar.labs.lab4;

public class Q4_RandomColors {
    public static void main(String[] args) {
        System.out.println(randomString());

    }

    public static String randomString() {

        String[] colors = {"red","blue","green","yellow","orange","pink","violet","indigo"};
        return colors[(int)(Math.random()*colors.length)];

    }
}
