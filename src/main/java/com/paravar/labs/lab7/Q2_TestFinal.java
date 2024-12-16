package com.paravar.labs.lab7;

public class Q2_TestFinal {
    public static void main(String[] args) {
        C a = new C(10);
        // a.p=20; // error
        System.out.println(C.R);
        //A.R=30;// error
    }
}
class C {
    final int p;
    public static final int R=20;
    /*{
        p=10;
    }*/

    C(int x){
        p=x;
    }
}