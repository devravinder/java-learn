package com.paravar.labs.lab8;

public class Q4_TestFinally {
    public static void main(String[] args) {

        int val = m1();
        System.out.println("val="+val);
    }

    public static int m1(){
        int x=0;
        try {
            System.out.println("in try x="+x );
            //((String)null).length();
            return ++x;
        }catch (Exception e){
            System.out.println("in catch x="+x );
            //((String)null).length();
            return ++x;
        }
        finally {
            System.out.println("in finally x="+x );
           // ((String)null).length();
            return ++x;
        }
    }
}
