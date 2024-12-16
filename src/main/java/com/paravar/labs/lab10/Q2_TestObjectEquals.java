package com.paravar.labs.lab10;

public class Q2_TestObjectEquals {
    public static void main(String[] args) {
        Person p1 = new Person("Ramu", 5);
        Person p2 = new Person("Ramu", 5);
        System.out.println("p1.equals(p2) "+p1.equals(p2));
        System.out.println("p1==p2"+ (p1==p2));
    }
}
class Person{
    String name;
    int height;

    public Person(String name, int height) {
        super();
        this.name = name;
        this.height = height;
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Person)
        {
            Person p = (Person) o;
            if(this.name.equals(p.name) && this.height == p.height)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Person" +name + height;
    }
}