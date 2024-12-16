package com.paravar.labs.lab7;

public class Q1_TestPet {

    public static void main(String[] args) {
        System.out.println(Pet.NAME);
        // Pet p = new Pet(); // error

        Pet p = new Doggy();
        p.play();
        // p.bark(); bark() is not present in the reference class ( i.e Pet )
    }
}

interface Pet {

    int X = 10; // public static final
    String NAME = "Pingu";
    public void play();

}

class Doggy implements Pet {

    public void play() {
        System.out.println("Doggy playing...");
    }
    public void bark(){
        System.out.println("Doggy barking...");
    }
}