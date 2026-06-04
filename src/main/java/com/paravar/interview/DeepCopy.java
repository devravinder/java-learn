package com.paravar.interview;

public class DeepCopy {
    public static void main(String[] args) throws Exception {

        Person p1 = new Person("John", new Address("Delhi"));
        Person p2 = p1.clone();

        p2.address.city = "Mumbai";

        System.out.println(p1.address.city); // Delhi ✅
        System.out.println(p2.address.city); // Mumbai
    }


}

class Address implements Cloneable {
    String city;

    Address(String city) {
        this.city = city;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone(); // primitives + immutable fields
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();   // shallow copy
        cloned.address = address.clone();         // deep copy step
        return cloned;
    }
}
