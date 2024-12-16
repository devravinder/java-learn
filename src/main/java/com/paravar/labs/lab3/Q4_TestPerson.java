package com.paravar.labs.lab3;

public class Q4_TestPerson {

    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name = "John";
        p1.age = 35;
        p1.eat();
        p1.sleep();

        Person p2 = new Person();
        p2.name = "Jane";
        p2.age = 40;
        p2.eat();
        p2.sleep();
    }
}

class Person {
    String name;
    int age;
    public void eat(){
        if(age<40)
            System.out.println("I eat more");
        else System.out.println("I eat less");

    }
    public void sleep(){
        if(age<40)
            System.out.println("I sleep less");
        else System.out.println("I sleep more");
    }
}
