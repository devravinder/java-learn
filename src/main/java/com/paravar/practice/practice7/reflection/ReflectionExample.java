package com.paravar.practice.practice7.reflection;

import java.lang.reflect.*;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Method to print info
    public void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Create a Person object
        Person person = new Person("John", 25);

        // Get the Class object associated with the Person class
        Class<?> personClass = Person.class; //person.getClass();

        // Print class name
        System.out.println("Class Name: " + personClass.getName());

        // Inspecting fields of the Person class
        System.out.println("Fields:");
        Field[] fields = personClass.getDeclaredFields();  // Get all fields (including private)
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }

        // Inspecting methods of the Person class
        System.out.println("\nMethods:");
        Method[] methods = personClass.getDeclaredMethods();  // Get all methods (including private)
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }

        // Accessing and modifying a private field using reflection
        System.out.println("\nAccessing and modifying private field 'name':");
        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);  // Make the field accessible even if it's private
        nameField.set(person, "Alice");  // Change the 'name' field value
        System.out.println("Updated Name: " + nameField.get(person));

        // Invoking a method using reflection
        System.out.println("\nInvoking 'printInfo' method:");
        Method printInfoMethod = personClass.getDeclaredMethod("printInfo");
        printInfoMethod.setAccessible(true);  // Make the method accessible even if it's private
        printInfoMethod.invoke(person);  // Call the 'printInfo' method on the person object
    }
}
