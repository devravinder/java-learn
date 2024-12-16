package com.paravar.labs.lab9.q2.riders;

public class TestHorse {
    public static void main(String[] args) {

        Horse horse = new Horse("Johny");
        //System.out.println("in TestHorse "+horse.name); // compilation error -> not accessible

        System.out.println("in horse "+ horse.getName());

        horse.sing();


    }
}
