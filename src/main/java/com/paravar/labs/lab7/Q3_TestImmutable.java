package com.paravar.labs.lab7;

public class Q3_TestImmutable {
    public static void main(String[] args) {
        Person p = new Person("Ramu");
        System.out.println(p.name);
        // p.name="Somu";// error
    }
}
final class Person{
 final String name;
  Person(String  name){
      this.name = name;
  }

}
