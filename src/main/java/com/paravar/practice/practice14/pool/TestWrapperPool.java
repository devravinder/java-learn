package com.paravar.practice.practice14.pool;

public class TestWrapperPool {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = new Integer(127);
        Integer i3 = Integer.valueOf(127);
        Integer i4 = 127;


        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i1 == i4);
        System.out.println("----------");


        System.out.println("====");

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6); // false, bcz byte pool range is -128 to 127 only


        Byte b = 127;
        // System.out.println(b == i1); // compilation error
        Byte b1 = 127;

        System.out.println(b == b1);

        System.out.println("========");
        System.out.println(System.identityHashCode(b)); // different address
        System.out.println(System.identityHashCode(i1)); // different address
        System.out.println(System.identityHashCode(i4)); // same as i4


        /*
        Wrapper pool exists for every wrapper class
          - Inter wrapper pool
          - Byte wrapper pool
          - etc

        - but all the wrapper pool range is -128 to 127

        * */


    }
}
