package com.paravar.labs.lab4;

public class Q2_TestString {
    public static void main(String[] args) {

        if(args.length == 2){
            testStringMethods(args[0], args[1]);
        }else {
            System.out.println("Please enter 2 names as command line arguments");
        }

    }
    public static void testStringMethods(String str1, String str2){


        int len = str1.length();
        System.out.println("length of string "+str1+" = "+str1.length());
        System.out.println("length of string "+str2+" = "+str2.length());

        System.out.println(str1+ " characters");
        for(int i = 0; i < len; i++)
        {
            char c = str1.charAt(i);
            System.out.println("char at "+i +" is "+ c);
        }

        System.out.println(str2+ " characters");
        char[] arr = str1.toCharArray();
        for (char c : arr)
        {
            System.out.println(c);
        }

        String upper = str1.toUpperCase();

        String lower = str1.toLowerCase();

        System.out.println(str1+ " Upper = "+upper);
        System.out.println(str1+ " Lower = "+lower);


        boolean res = str1.equals(str2);
        System.out.println(str1+" equals "+str2+" = "+res);



        res = str1.equalsIgnoreCase(str2);
        System.out.println(str1+" equals ignore case "+str2+" = "+res);



        int compare = str1.compareTo(str2); // alphabetical comparison
        System.out.println(str1+" compare to "+str2+" = "+compare);

        boolean contains = str1.contains(str2);
        int index = str1.indexOf(str2);
        System.out.println(str1+" contains "+str2+" = "+contains + " at index "+ index);


        String str9 = new String("Hello");
        String str10 = "Hi";
        System.out.println(str9 + " "+ str10);


        String fullname = str1.concat(" "+str2);
        System.out.println("Full name = "+fullname);
        System.out.println(fullname.length() > 12 ? "You have very long name" : "You have good name");

    }
}
