package com.paravar.labs.lab3;

public class Q3_TestPen {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.color = "black";
        System.out.println("inkQty in p1 = "+p1.inkQty);
        p1.refill(2);
        System.out.println("inkQty in p1 = "+p1.inkQty);
        p1.write("Hello, good morning");
        System.out.println("inkQty in p1 = "+p1.inkQty);
        p1.write("How are you?");
        System.out.println("inkQty in p1 = "+p1.inkQty);
        p1.write("what to write only i don't know...");
    }
}
class Pen{
    int inkQty;
    String color;
    public void write(String data){
        if(inkQty > 0){
            System.out.println("Pen writing "+ data+" in "+color+" color");
            inkQty--;
        }
        else
            System.out.println("no ink, first fill ink and then write...");
    }
    public void refill(int qty)
    {
        inkQty = inkQty + qty;
    }
}