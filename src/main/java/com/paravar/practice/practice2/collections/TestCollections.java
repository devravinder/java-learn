package com.paravar.practice.practice2.collections;

import java.util.*;

public class TestCollections {
    public static void main(String[] args) {

        /*
         Note:-
            - Vector & Stack legacy... use ArrayDeque ( Deque )
            - all the sorting collections won't allow null
                eg:  PriorityQueue, , TreeSet, TreeMap

                 - and also ArrayDeque also won't allow null values

            - Maps sort by keys


        * */

        /*
         List:-
            - insertion order
            - duplicates allowed
            - types:
                - Array List   - array data structure
                - Linked List  - doubly linked list
                - Vector       - array data structure, legacy, threads safe
                - Stack        - LIFO data structure (doubly linked list ), legacy, threads safe
                               - extends vector



        */
        System.out.println("===============List===========");
        testArrayList();
        testLinkedList();
        testVector();
        testStack();

        /*
         Set:-
            - no order (depends)
            - no duplicates
            - types:
                - Hash Set     - hash table, no order
                - Linked Hash  - hash table, doubly linked list, insertion order
                - Tree Set     - red black tree, sorted ( natural sort by default )
        */
        System.out.println("=============Set=========");

        testHashSet();
        testLinkedHashSet();
        testTreeSet();

        /*
         Queue:-
            - sorted ( natural order by default )
            - duplicates allowed
            - doesn't allow null
            - FIFO / LIFO data structure
            - types:
                - PriorityQueue - elements based on priority
                - Deque - (double-ended queue for FIFO or LIFO)


            - adding in queue - offer, add
            - removing from queue - poll, remove
                   - peek - gives top one... but won't remove
        * */

        System.out.println("====================Queue===============");

        testPriorityQueue();
        testArrayDeque();

        /*
        Map:-
          - key, value pair
          - types:
                - HashMap           - no order, Hash table data structure
                - LinkedHashMap     - insertion order, Hash Table & Linked List
                - TreeMap           - sorted ( natural order by default ), Red-Black Tree
   *****        - EnumMap           - HashMap for Enums as key
        * */

        System.out.println("==============Map==========");

        testHashMap();
        testLinkedHashMap();
        testTreeMap();


    }


    public static void testArrayList() {
        /*
         ArrayList:-
           - Maintains insertion order
           - Allows duplicates
           - Backed by dynamic array ( array data structure)
        */
        System.out.println("ArrayList Example:");
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana"); // Duplicate allowed

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println();
    }

    public static void testLinkedList() {
        /*
         LinkedList:-
           - Maintains insertion order
           - Allows duplicates
           - Backed by doubly linked list
        */
        System.out.println("LinkedList Example:");
        List<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana"); // Duplicate allowed

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println();
    }

    public static void testVector() {
        /*
         Vector:-
           - Maintains insertion order
           - Allows duplicates
           - Synchronized (thread-safe)
           - Legacy class backed by dynamic array
        */
        System.out.println("Vector Example:");
        Vector<String> fruits = new Vector<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana"); // Duplicate allowed

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Accessing elements
        System.out.println("First element: " + fruits.firstElement());
        System.out.println("Last element: " + fruits.lastElement());
        System.out.println("Size: " + fruits.size());
        System.out.println();
    }

    public static void testStack() {
        /*
         Stack:-
           - Last In First Out (LIFO) data structure
           - Extends Vector
           - Thread-safe (synchronized)
           - linked list data structure
        */
        System.out.println("Stack Example:");
        Stack<String> books = new Stack<>();
        books.push("Book 1"); // Pushes an element onto the stack
        books.push("Book 2");
        books.push("Book 3");

        // Display the stack
        System.out.println("Stack: " + books);

        // Accessing top element without removing it
        System.out.println("Top of the stack: " + books.peek());

        // Removing elements from the stack
        while (!books.isEmpty()) {
            System.out.println("Popped: " + books.pop()); // Removes and returns the top element
        }

        System.out.println();
    }

    //==============================================

    public static void testHashSet() {
        /*
         HashSet:-
           - Does not maintain insertion order
           - Does not allow duplicates
           - Backed by hash table
        */
        System.out.println("HashSet Example:");
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana"); // Duplicate ignored

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println();
    }

    public static void testLinkedHashSet() {
        /*
         LinkedHashSet:-
           - Maintains insertion order
           - Does not allow duplicates
           - Backed by hash table and linked list
        */
        System.out.println("LinkedHashSet Example:");
        Set<String> fruits = new LinkedHashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana"); // Duplicate ignored

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println();
    }

    public static void testTreeSet() {
        /*
         TreeSet:-
           - Stores unique elements (no duplicates)
           - sorted
           - Maintains natural sorting order (ascending by default)
           - Backed by a Red-Black Tree
        */
        System.out.println("TreeSet Example:");
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(1); // Duplicate ignored

        // Iterating through the TreeSet
        for (Integer number : numbers) {
            System.out.println(number);
        }

        // Additional TreeSet methods
        System.out.println("First element: " + numbers.first()); // Smallest element
        System.out.println("Last element: " + numbers.last());   // Largest element
        System.out.println("Higher than 3: " + numbers.higher(3)); // Element greater than 3
        System.out.println("Lower than 3: " + numbers.lower(3));   // Element less than 3
        System.out.println();
    }

    //=================================
    public static void testPriorityQueue() {
        /*
         PriorityQueue:-
           - Elements are ordered based on priority (natural order by default)
           - Allows duplicates
           - Backed by a heap
        */
        System.out.println("PriorityQueue Example:");
        Queue<String> tasks = new PriorityQueue<>();
        tasks.add("Task 3");
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 1"); // Duplicate allowed

        while (!tasks.isEmpty()) {
            System.out.println(tasks.poll()); // Retrieves elements in natural order
        }
        System.out.println();
    }

    public static void testArrayDeque() {
        /*
         ArrayDeque:-
           - Can be used as a FIFO (queue) or LIFO (stack)
           - Does not allow `null` elements
           - Backed by a resizable array
           - no sorting
        */
        System.out.println("ArrayDeque Example:");
        Deque<String> tasks = new ArrayDeque<>();
        tasks.add("Task 1"); // Add to the tail
        tasks.add("Task 3"); // Add to the tail
        tasks.addFirst("Task 0"); // Add to the head
        tasks.addLast("Task 2"); // Add to the tail

        for (String task : tasks) {
            System.out.println(task);
        }
        System.out.println();
    }

    //=====================
    public static void testHashMap() {
        /*
         HashMap:-
           - no order
           - Allows one null key and multiple null values
           - Backed by hash table
        */
        System.out.println("HashMap Example:");
        Map<Integer, String> studentGrades = new HashMap<>();
        studentGrades.put(1, "A");
        studentGrades.put(2, "B");
        studentGrades.put(11, "I");
        studentGrades.put(4, "D");
        studentGrades.put(3, "A");
        studentGrades.put(2, "C"); // Key 2 is updated

        for (Map.Entry<Integer, String> entry : studentGrades.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Grade: " + entry.getValue());
        }
        System.out.println();
    }

    public static void testLinkedHashMap() {
        /*
         LinkedHashMap:-
           - Stores key-value pairs
           - Maintains insertion order of keys
           - Allows one null key and multiple null values
           - Backed by a hash table with a linked list
        */
        System.out.println("LinkedHashMap Example:");
        LinkedHashMap<Integer, String> studentGrades = new LinkedHashMap<>();
        studentGrades.put(104, "C");
        studentGrades.put(101, "A");
        studentGrades.put(102, "B");
        studentGrades.put(103, "A");

        // Iterating through the LinkedHashMap
        for (Map.Entry<Integer, String> entry : studentGrades.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Grade: " + entry.getValue());
        }

        // Accessing specific elements
        System.out.println("Grade of Student 102: " + studentGrades.get(102));
        System.out.println("Contains Student 101? " + studentGrades.containsKey(101));
        System.out.println("Contains Grade 'C'? " + studentGrades.containsValue("C"));
        System.out.println();
    }
    public static void testTreeMap() {
        /*
         TreeMap:-
           - Maintains sorted order of keys
           - Does not allow null keys
           - Backed by Red-Black tree
        */
        System.out.println("TreeMap Example:");
        Map<Integer, String> studentGrades = new TreeMap<>();
        studentGrades.put(3, "A");
        studentGrades.put(1, "B");
        studentGrades.put(2, "A");

        for (Map.Entry<Integer, String> entry : studentGrades.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Grade: " + entry.getValue());
        }
        System.out.println();
    }


}
