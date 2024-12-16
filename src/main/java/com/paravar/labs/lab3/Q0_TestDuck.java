package com.paravar.labs.lab3;

public class Q0_TestDuck {
    public static void main(String[] args) {

        Duck d1 = new Duck();
        Duck d2 = new Duck();
        d1.tailSize = 10;
        d2.tailSize = 20;

        d1.swim();
        d2.swim();

        System.out.println("d1.tailSize = "+d1.tailSize);
        System.out.println("d2.tailSize = "+d2.tailSize);

        d1.tailSize = d2.tailSize;

        System.out.println("after d1.tailSize = d2.tailSize");

        System.out.println("d1.tailSize = "+d1.tailSize);
        System.out.println("d2.tailSize = "+d2.tailSize);

        d1.tailSize = 30;
        System.out.println("after d1.tailSize = 30");

        System.out.println("d1.tailSize = "+d1.tailSize);
        System.out.println("d2.tailSize = "+d2.tailSize);

        d1 = d2;
        System.out.println("after d1 = d2");

        System.out.println("d1.tailSize = "+d1.tailSize);
        System.out.println("d2.tailSize = "+d2.tailSize);

        d1 = d2 = null;
        System.out.println("after d1 = d2 = null");

        //System.out.println("d1.tailSize = "+d1.tailSize); // error
        //System.out.println("d2.tailSize = "+d2.tailSize); // error

        d1 = new Duck();
        System.out.println("after d1 = new Duck()");

        System.out.println("d1.tailSize = "+d1.tailSize);
        //System.out.println("d2.tailSize = "+d2.tailSize); // error

    }
}
class Duck{
    int tailSize;

    public void swim() {
        System.out.println("Swimming");
    }

}