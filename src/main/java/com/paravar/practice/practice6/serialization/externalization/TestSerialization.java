package com.paravar.practice.practice6.serialization.externalization;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) {
        /*
        Serialization:-
           converting an object into a byte stream
            - to save to a file
            - transmitted over a network
            - otherwise persisted.

            - conversion is handled by JVM
            - no need to override any methods

        De-Serialization:-
            converting byte stream to object
        */

        String path = "./src/files/person.ser.txt";
        Person person = new Person("Alice", 30);

        serialize(person, path);

        Person person2 = deSerialize(path);

        System.out.println("person2 "+person2);


    }

    public static void serialize(Person person, String path) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            // Serialize the object
            oos.writeObject(person);
            System.out.println("Serialization completed: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deSerialize(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            // Deserialize the object
            Person person = (Person) ois.readObject();
            System.out.println("Deserialization completed: " + person);
            return person;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
// Serializable class
class Person implements Serializable {


    // this is like id for byte class...
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization


    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding toString for readable output
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
