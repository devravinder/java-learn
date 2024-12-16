package com.paravar.practice.practice2.collections;

import java.util.*;

class User implements Comparable<User> {
    private String name;
    private int age;
    private double salary;

    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(User other) {
        // Natural order: Sort by age
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}

// Comparator for third-party sorting by salary
class SalaryComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return Double.compare(u1.getSalary(), u2.getSalary());
    }
}

public class TestSorting {

    public static void main(String[] args) {
        // Create some users
        User user1 = new User("Alice", 30, 50000);
        User user2 = new User("Bob", 25, 45000);
        User user3 = new User("Charlie", 35, 55000);
        User user4 = new User("David", 28, 48000);

        // 1. PriorityQueue (Natural order by age)
        System.out.println("PriorityQueue (Natural Order - By Age):");
        PriorityQueue<User> pqByAge = new PriorityQueue<>();
        pqByAge.add(user1);
        pqByAge.add(user2);
        pqByAge.add(user3);
        pqByAge.add(user4);
        while (!pqByAge.isEmpty()) {
            System.out.println(pqByAge.poll());
        }
        System.out.println();

        // PriorityQueue with SalaryComparator
        System.out.println("PriorityQueue (Third Party Order - By Salary):");
        PriorityQueue<User> pqBySalary = new PriorityQueue<>(new SalaryComparator());
        pqBySalary.add(user1);
        pqBySalary.add(user2);
        pqBySalary.add(user3);
        pqBySalary.add(user4);
        while (!pqBySalary.isEmpty()) {
            System.out.println(pqBySalary.poll());
        }
        System.out.println();

        // 2. TreeSet (Natural order by age)
        System.out.println("TreeSet (Natural Order - By Age):");
        TreeSet<User> treeSet = new TreeSet<>();
        treeSet.add(user1);
        treeSet.add(user2);
        treeSet.add(user3);
        treeSet.add(user4);
        for (User user : treeSet) {
            System.out.println(user);
        }
        System.out.println();

        // 3. TreeSet with Salary Comparator
        System.out.println("TreeSet (Third Party Order - By Salary):");
        TreeSet<User> treeSetBySalary = new TreeSet<>(new SalaryComparator());
        treeSetBySalary.add(user1);
        treeSetBySalary.add(user2);
        treeSetBySalary.add(user3);
        treeSetBySalary.add(user4);
        for (User user : treeSetBySalary) {
            System.out.println(user);
        }
        System.out.println();

        // 4. TreeMap (Natural order by age as keys)
        System.out.println("TreeMap (Natural Order - By Age):");
        TreeMap<User, String> treeMapByAge = new TreeMap<>();
        treeMapByAge.put(user1, "Alice Info");
        treeMapByAge.put(user2, "Bob Info");
        treeMapByAge.put(user3, "Charlie Info");
        treeMapByAge.put(user4, "David Info");
        for (Map.Entry<User, String> entry : treeMapByAge.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        // TreeMap with SalaryComparator
        System.out.println("TreeMap (Third Party Order - By Salary):");
        TreeMap<User, String> treeMapBySalary = new TreeMap<>(new SalaryComparator());
        treeMapBySalary.put(user1, "Alice Info");
        treeMapBySalary.put(user2, "Bob Info");
        treeMapBySalary.put(user3, "Charlie Info");
        treeMapBySalary.put(user4, "David Info");
        for (Map.Entry<User, String> entry : treeMapBySalary.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        // 5. List (Sort by both ways)
        System.out.println("List Sorting:");
        List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));

        // Sort by natural order (age)
        System.out.println("List sorted by Age:");
        Collections.sort(userList); // Using Collections.sort
        for (User user : userList) {
            System.out.println(user);
        }

        // Sort by salary using Comparator
        System.out.println("\nList sorted by Salary:");
        userList.sort(new SalaryComparator());
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
