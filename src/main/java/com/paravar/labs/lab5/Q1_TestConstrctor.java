package com.paravar.labs.lab5;

public class Q1_TestConstrctor {
    public static void main(String[] args) {
            Child ramu = new Child();
            Child ravi = new Child("Ravi");
            Child raju = new Child("Raju", 25);

            ramu.setAge(130);
            ramu.setAge(30);
            ramu.setName("Rama Krishna");

        System.out.println("Name = " + ramu.getName() + " Age = " + ramu.getAge());

        System.out.println("Name = " + ravi.getName() + " Age = " + ravi.getAge());

        System.out.println("Name = " + raju.getName() + " Age = " + raju.getAge());

        System.out.println("Total Persons "+ Child.personsCount);
    }
}
class Child {
    private String name;
    private int age;

    static int personsCount = 0;

    public Child() {
        System.out.println(" No args constructor called");
        personsCount++;
    }

    public Child(String name) {
        System.out.println("Single arg constructor called");
        this.setName(name);
        personsCount++;

    }

    public Child(String name, int age) {
        this(name); // constructor should be 1st statement
        // this.setName(name);
        this.setAge(age);
        System.out.println("Multiple args constructor called");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            System.out.println("Name cannot be null or empty");
            return;
        }
        if(name.length() > 30){
            System.out.println(" Name cannot be longer than 30 characters");
            return;
        }
        this.name = name;


    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0 || age>120)
        {
            System.out.println("Invalid age");
            return;
        }
        this.age = age;
    }
}