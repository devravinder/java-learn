package com.paravar.labs.lab5;

public class Q7_WrapperClasses {
    public static void main(String[] args) {
        int i = 10;
        Integer int1 = Integer.valueOf(i); // boxing
        int j = int1.intValue(); // unboxing
        System.out.println("int1 = "+int1+" j = "+j);

        Integer int2 = 20;// auto boxing
        int k = int2; // auto unboxing
        System.out.println("int2 = "+int2+" k = "+k);

        System.out.println("isWholeNumber = "+isWholeNumber(10.2));// auto boxing




    }

    public static boolean isWholeNumber(Double d) {
        return d % 1 == 0;
    }
}
