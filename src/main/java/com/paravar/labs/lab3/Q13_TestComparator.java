package com.paravar.labs.lab3;

public class Q13_TestComparator {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name = "John";
        p1.age = 35;
        Person p2 = new Person();
        p2.name = "Jane";
        p2.age = 40;
        PersonComparator pc = new PersonComparator();
        int compareResult = pc.compare(p1, p2);
        if(compareResult < 0)
            System.out.println(p1.name + " is younger than " + p2.name);
        else if(compareResult > 0)
            System.out.println(p1.name + " is older than " + p2.name);
        else
            System.out.println(p1.name + " and " + p2.name + " are of same age");
    }
}
class PersonComparator{
    public int compare(Person p1, Person p2){
        return p1.age- p2.age;
    }
}