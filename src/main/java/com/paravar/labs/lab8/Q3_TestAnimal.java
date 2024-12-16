package com.paravar.labs.lab8;

public class Q3_TestAnimal {

    public static void main(String[] args) {
        try {
            m1();
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }
    static void m3(Animal a){
        System.out.println("in m3");
        if(a instanceof Pig){
            Pig p = (Pig) a;
        }

    }
    static void m2(){

        System.out.println("in m2");
        Animal a = new Animal();

        m3(a);

        Pig p = new Pig();
        m3(p);

    }
    static void m1(){
        System.out.println("in m1");
        m2();
    }
}

class Animal {
    public void eat() {
    }
}

class Pig extends Animal{

}