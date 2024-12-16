package com.paravar.labs.lab6;

public class Q3_TestAnimal {
    public static void main(String[] args) {

        Animal a = new Croc();
        Animal b = new Hippo();

        Vet v = new Vet();
        v.treat(a);
        v.treat(b);
    }
}
class Animal{
    String name;

    public void eat()
    {
        System.out.println("animal eating...");
    }
    public void sleep()
    {
        System.out.println("animal sleeping...");
    }
    public void dance()
    {
        System.out.println("animal dancing...");
    }
}
class Hippo extends Animal{
    public void smoke()
    {
        System.out.println("Hippo smoking...");
    }
}

class Croc extends Animal {
    public void swim()
    {
        System.out.println("Croc swimming...");
    }

    public void sleep()
    {
        System.out.println("Croc sleeping...");
    }
}

class Vet {

    public void treat(Animal a) // polymorphic code
    {
        a.dance();
        a.eat();
        a.sleep();
        if(a instanceof Croc c)
        {
            c.swim();
        }


    }
}