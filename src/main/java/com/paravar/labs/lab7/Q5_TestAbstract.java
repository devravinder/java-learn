package com.paravar.labs.lab7;

public class Q5_TestAbstract {
    public static void main(String[] args) {

        // Animal a = new Animal();// error

        Animal a = new Croc();
        a.eat();
        a.sleep();
    }
}
abstract class Animal {
    String name;

    public Animal() {
        System.out.println("in Animal no-arg constructor");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("in Animal 1-arg constructor");
    }


    public void sleep(){
        System.out.println("sleeping with eyes closed");
    }
    abstract public void eat();

}

class Croc extends Animal {

    public Croc() {
        System.out.println("in Croc no-arg constructor");
    }

    public Croc(String name) {
        super(name);
        System.out.println("in Croc 1-arg constructor");
    }

    @Override
    public void eat() {
        System.out.println("croc eating");
    }

    @Override
    public void sleep() {
        System.out.println("croc sleeping");
    }
}

