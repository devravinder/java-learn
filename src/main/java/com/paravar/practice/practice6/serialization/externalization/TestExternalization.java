package com.paravar.practice.practice6.serialization.externalization;
import java.io.*;

public class TestExternalization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        Externalization:-
          - a better version of serialization
          - we can implement custom serialization
          - we can serialize only required fields  ( performance & memory )
          - we can ignore methods
          - required mandatory no arg constructor

          - we need to handle conversion ( obj to bytes )
          - need to override readExternal & writeExternal

        * */

        Employee employee = new Employee("Alice", 30);

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            oos.writeObject(employee);
        }

        // Deserialize the object
        Employee deserializedEmployee;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            deserializedEmployee = (Employee) ois.readObject();
        }

        System.out.println("Deserialized Employee: " + deserializedEmployee);
    }
}

class Employee implements Externalizable {
    private String name;
    private int age;

    // Mandatory no-arg constructor
    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Custom serialization logic
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    // Custom deserialization logic
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + "}";
    }
}

