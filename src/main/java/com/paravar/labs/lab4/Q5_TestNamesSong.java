package com.paravar.labs.lab4;

public class Q5_TestNamesSong {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name = "John";
        p1.age = 35;
        p1.addPetName("Tiger");
        p1.addPetName("Lion");
        p1.addPetName("Cat");
        p1.addPetName("Dog");
        System.out.println(p1.sing());
    }
}
class Person {
    String name;
    int age;
    String[] petNames = new String[20];
    private int namesCount;

    public String sing(){
        String song = "";
        for(int i = 0; i < namesCount; i++)
            song += " " + petNames[(int)(Math.random()* namesCount)];
        return song;
    }

    public void addPetName(String name) {
        if(namesCount < petNames.length)
            petNames[namesCount++] = name;
        else System.out.println("Pat names are enough");

    }

    public boolean searchPetName(String name) {
        for( String petName: petNames)
            if(petName.equals(name))
                return true;
        return false;
    }
}