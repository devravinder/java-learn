package com.paravar.labs.lab9.q2.zoo;

public class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sing(){
        System.out.println("Animal is singing "+name);
    }

    public String getName() {
        return name;
    }
}
