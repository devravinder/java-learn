package com.paravar.labs.lab4;

public class Q12_StringAndStringBuilder {
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abc";  // how many objects are created
        System.out.println(s1==s2); // string literals in pools

        String s3 = new String("abc"); // string object in heap // how many objects are created
        System.out.println(s1==s3);

        System.out.println(s1.equals(s3));


        String s4 = "happynew";
        s4.concat("year");
        System.out.println(s4); // what is printed? why?"



        StringBuilder s5 = new StringBuilder("happynew");
        s5.append("year");
        System.out.println(s5);
        System.out.println(s5.reverse());
        System.out.println(s5);
    }
}
