package com.paravar.labs.lab8;

public class Q6_TestValidation {
    public static void main(String[] args) {
        try {
            Person p = new Person("John", 61); // new Person("John", -61);
            p.dance();
            System.out.println(p.getName() + " " + p.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (DanceFailueException e) {
            System.out.println("=========="+e.getMessage());
        }
    }
}
class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
       this.setName(name);
       this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Invalid name");
        this.name = name;
    }

    public int getAge() {
        if(age < 0 || age > 100)
            throw new IllegalArgumentException("Invalid age");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void dance() throws DanceFailueException{
        if(age > 50){
            System.out.println(" salsa dance");
            throw new DanceFailueException("Tired, unable to dance");
        }
    }
}

class DanceFailueException extends Exception{
    public DanceFailueException(String message){
        super(message);
    }
}