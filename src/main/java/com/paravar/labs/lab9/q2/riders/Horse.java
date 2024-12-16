package com.paravar.labs.lab9.q2.riders;

import com.paravar.labs.lab9.q2.zoo.Animal;

public class Horse extends Animal {

    Horse(String name) {
        super(name);
    }
    @Override
    public void sing() {
        System.out.println("Horse is singing "+ name);// if  name package then it is is not accessible
                                                      // if protected then it is accessible
    }
}
