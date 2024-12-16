package com.paravar.labs.lab9.q2.test;

import com.paravar.labs.lab9.q2.zoo.Animal;
import com.paravar.labs.lab9.q2.zoo.Hippo;

public class TestAnimal {
    public static void main(String[] args) {

        Animal hippo = new Hippo("Moosy");

//        System.out.println(" in hippo "+ hippo.name); //  // compilation error -> not accessible

        System.out.println("in hippo "+ hippo.getName());

        hippo.sing();

    }
}
