package com.paravar.labs.lab8;

public class Q2_TestExceptions {
    public static void main(String[] args) {

        //nullException(null);
        //castEx();
        //numberFormatEx("2a");
        //outOfStackMemoryError();
        //ourOfMemoryError();
    }
    public static void nullException(String s) {
        try {
            System.out.println(s.length());
        } catch (NullPointerException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }

    public static void castEx(){
        try {
            Object i = Integer.valueOf(2);
            String st = (String) i;
        } catch (ClassCastException e) {
           e.printStackTrace();
        }
    }

    public static void numberFormatEx(String s){
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public static void outOfStackMemoryError(){
        test();
        System.out.println("hello");
    }
    public static void ourOfMemoryError(){
        try {
            String[] arr = new String[-1>>>1];
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }
    public static void test(){
        try {
            test();
        } catch (StackOverflowError e) {
            System.out.println("=======");
            //e.printStackTrace();
            //System.out.println(e.getMessage()+" Message");
        }
    }
}
