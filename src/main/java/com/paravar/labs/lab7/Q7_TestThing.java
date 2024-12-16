package com.paravar.labs.lab7;

public class Q7_TestThing {
    public static void main(String[] args) {

        Thing thing = new Spanner();
        Tool tool = new Spanner();

        Human human = new Human();
        human.testThing(thing);
        human.testThing(tool);


        Thing tubeLight = new TubeLight();
        Thing vehicle = new Vehicle();
        human.testThing(tubeLight);
        human.testThing(vehicle);
    }
}
interface Thing{
    public void doSomething();
}
class Tool implements Thing{
    @Override
    public void doSomething() {
        System.out.println("Thing doing something");
    }
}

class Spanner extends Tool{
    @Override
    public void doSomething() {
        System.out.println("Spanner doing something");
    }
}

class TubeLight implements Thing{
    @Override
    public void doSomething() {
        System.out.println("Rendering light");
    }
}

class Vehicle implements Thing{
    @Override
    public void doSomething() {
        System.out.println("Vehicle is going ");
    }
}

class Human {
    public void testThing( Thing thing){
        thing.doSomething();
    }
}
