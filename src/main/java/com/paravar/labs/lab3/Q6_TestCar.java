package com.paravar.labs.lab3;

public class Q6_TestCar {
    public static void main(String[] args) {

        Car c1 = new Car();
        c1.name = "BMW";
        c1.fuelQty = 2;
        c1.start();
        c1.drive();
        c1.reverse();
        c1.stop();
        c1.start();
        c1.drive();

    }
}

class Car{
    String name;
    int fuelQty;
    boolean isStarted;

    public void start(){
        if(fuelQty>0){
            isStarted = true;
            System.out.println(name +" Car started");
        }
        else System.out.println("No fuel, unable to start");

    }
    public void drive(){
        if(isStarted){
            if(fuelQty > 0){
                fuelQty--;
                System.out.println(name +" Car driving");
            }else {
                System.out.println("No fuel, unable to drive");
            }

            if(fuelQty==0)
                stop();
        }
        else System.out.println("Car not started, unable to drive");
    }
    public void reverse(){
        if(isStarted){
            if(fuelQty > 0){
                fuelQty--;
                System.out.println(name +" Car reversing");
            }else {
                System.out.println("No fuel, unable to reverse");
            }
            if(fuelQty==0)
                stop();
        }
        else System.out.println("Car not started, unable to reverse");
    }
    public void stop(){
        isStarted = false;
        System.out.println(name +" Car stopped");
    }
}
