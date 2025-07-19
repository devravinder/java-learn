package com.paravar.practice.practice16.records;

public class TestRecords {
    public static void main(String[] args) {

        User user = new User("Ramu", 23);

        System.out.println(user);
        System.out.println(user.age());

        Employee a = new Employee("R", "EMP1");
        System.out.println(a.welcome());

        Employee b = new Employee("B", "vvv");

    }
}

/*
  records: immutable data carriers
     - fields are private & final
     - equals(), hashCode(), toString() implementation
     - public getter
     - no setters - immutable
*
* */

record User(String name, int age){}


record Employee(String name, String empId){
    public Employee{
        if(null == empId || !empId.startsWith("EMP"))
            throw  new IllegalArgumentException("Invalid Emp id");
    }

    public String welcome() {
        return " hello "+name;
    }
}