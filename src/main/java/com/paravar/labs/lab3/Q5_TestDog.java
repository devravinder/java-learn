package com.paravar.labs.lab3;

public class Q5_TestDog {
    public static void main(String[] args) {

        Dog d1 = new Dog();
        d1.name = "Tommy";
        d1.bark();
        //d1.age = 5;
        d1.setAge(5);
        d1.bark();

        d1.setAge(11);
        d1.bark();
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