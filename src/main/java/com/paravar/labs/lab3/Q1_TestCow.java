package com.paravar.labs.lab3;

public class Q1_TestCow {
    public static void main(String[] args) {
        Cow c1 = new Cow();
        c1.name = "Jonny";
        c1.moo();
        Cow c2 = c1;// new Cow();
        System.out.println("name of c2 = "+c2.name);
        c2.name = "Bonnie";
        c2.moo();
    }
}
class Cow
{
    String name;

    public void moo()
    {
        System.out.println("Me cow "+name+" going moo moo...");
    }
}
