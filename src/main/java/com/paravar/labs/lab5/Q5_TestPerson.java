package com.paravar.labs.lab5;

public class Q5_TestPerson {
    public static void main(String[] args) {

        Car car = new Car();
        car.name = "BMW";
        car.fuelQty = 2;

        Dog dog = new Dog();
        dog.name = "Rex";
        dog.setAge(3);

        Song song = new Song("Hosanna", "Hosanna Hosanna Hosanna Hoooo Saa naa");

        Person p1 = new Person("John", car, dog, song);
        p1.walk();
        p1.commute("London");
        p1.sing();
        p1.eat(new Food("Pizza", 10));
    }
}
class Person {
    private String name;
    private Car car;
    private Dog petDog;
    private Song favoriteSong;

    public Person(String name, Car car, Dog petDog, Song favoriteSong) {
        this.name = name;
        this.car = car;
        this.petDog = petDog;
        this.favoriteSong = favoriteSong;
    }

    public void commute(String destination){

        this.car.start();
        this.car.drive();
        this.car.stop();
        System.out.println("Reached "+destination);
    }

    public void walk(){
        System.out.println("Walking with "+petDog.name);
        petDog.bark();
    }

    public void sing(){
        favoriteSong.play();
    }
    public void eat(Food food){
        System.out.println("Eating "+food.getName()+" at "+food.getPrice());
    }
}

class Food {
    private String name;
    private int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
class Dog{

    String name;
    private int age;
    public void bark(){
        if(age<=0){
            System.out.println("Hello, please set age");
            return;
        }

        if(age>10){
            System.out.println("Meow Meow "+name);
        }
        else{
            System.out.println("Bow Bow "+name);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if( age > 0 && age < 12)
            this.age = age;
        else System.out.println("invalid age for dog");
    }
}