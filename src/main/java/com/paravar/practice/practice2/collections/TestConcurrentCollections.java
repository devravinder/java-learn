package com.paravar.practice.practice2.collections;
import java.util.concurrent.*;
import java.util.*;

public class TestConcurrentCollections {

    public static void main(String[] args) throws InterruptedException {

        /*
           Concurrent Collections:-
               -  designed to be used in multithreaded environments
                    where multiple threads may perform read and write operations concurrently
                    without the need for explicit synchronization
               - thread safe collections
               - but No, operations are designed to avoid blocking threads
                   - does not block threads for general operations ( add, remove, iterate )
                   - Concurrent access to shared data structures
                      like maps, sets, and lists without blocking
               - no need of explicit need for explicit synchronization


         List Types:-
            - CopyOnWriteArrayList
                - ArrayList counter-part
                - A thread-safe list optimized for read-heavy workloads
                   writes result in a new copy of the list.

            - ConcurrentLinkedQueue
                - Queue ( LinkedList ) counter-part
                - A thread-safe, lock-free, unbounded queue.

            - ConcurrentLinkedDeque
                - Deque ( LinkedList ) counter-part
                - A thread-safe, lock-free, unbounded deque.


          Set Types:-
             - CopyOnWriteArraySet
                - HashSet counter-part
                - A thread-safe set implemented using CopyOnWriteArrayList.

             - ConcurrentSkipListSet
                - TreeSet counter-part
                - A thread-safe sorted set based on a skip list.

         Map Types:-
            - ConcurrentHashMap
                 - HashMap counter-part
                 - A thread-safe map that allows high-concurrency for reads and writes.

            - ConcurrentSkipListMap
                 - TreeMap counter-part
                 - A thread-safe sorted map based on a skip list.


         */

        testCopyOnWriteArrayList();
        testConcurrentLinkedQueue();
        testConcurrentLinkedDeque();


        testCopyOnWriteArraySet();
        testConcurrentSkipListSet();

        testConcurrentHashMap();
        testConcurrentSkipListMap();


    }
    // Testing ConcurrentHashMap
    public static void testConcurrentHashMap() {
        // ConcurrentHashMap is a thread-safe map for concurrent access.
        System.out.println("Testing ConcurrentHashMap:");

        // Creating a ConcurrentHashMap
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

        // Putting values into the map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Retrieving a value (thread-safe)
        System.out.println("Value for key 'B': " + map.get("B")); // Output: 2

        // Putting a value if absent
        map.putIfAbsent("D", 4);
        System.out.println("Value for key 'D' after putIfAbsent: " + map.get("D")); // Output: 4

        // Checking if the map contains a key
        System.out.println("Contains key 'A': " + map.containsKey("A")); // Output: true
    }

    // Testing CopyOnWriteArrayList
    public static void testCopyOnWriteArrayList() {
        // CopyOnWriteArrayList is a thread-safe variant of ArrayList for concurrent read and write operations.
        System.out.println("\nTesting CopyOnWriteArrayList:");

        // Creating a CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();

        // Adding elements (thread-safe)
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Iterating through the list (threads can safely read while writing)
        for (String fruit : list) {
            System.out.println(fruit);  // Output: Apple, Banana, Cherry
        }

        // Modifying the list (does not affect iterators)
        list.add("Date");
        System.out.println("Updated list: " + list); // Output: [Apple, Banana, Cherry, Date]
    }

    // Testing CopyOnWriteArraySet
    public static void testCopyOnWriteArraySet() {
        // CopyOnWriteArraySet is a thread-safe variant of HashSet using CopyOnWriteArrayList.
        System.out.println("\nTesting CopyOnWriteArraySet:");

        // Creating a CopyOnWriteArraySet
        Set<String> set = new CopyOnWriteArraySet<>();

        // Adding elements (thread-safe)
        set.add("Apple");
        set.add("Banana");
        set.add("Apple");  // Duplicates are not allowed, but this does not block threads.

        // Iterating through the set
        System.out.println("Contents of CopyOnWriteArraySet:");
        for (String fruit : set) {
            System.out.println(fruit);  // Output: Apple, Banana (No duplicates)
        }

        // Modifying the set (does not affect iterators)
        set.add("Cherry");
        System.out.println("Updated set: " + set);  // Output: [Apple, Banana, Cherry]
    }

    public static void testConcurrentSkipListSet() {
        // ConcurrentSkipListSet is a thread-safe, sorted set implemented using a skip list.
        System.out.println("\nTesting ConcurrentSkipListSet:");

        // Creating a ConcurrentSkipListSet
        Set<Integer> skipListSet = new ConcurrentSkipListSet<>();

        // Adding elements (thread-safe)
        skipListSet.add(30);
        skipListSet.add(10);
        skipListSet.add(20);
        skipListSet.add(10);  // Duplicates are not allowed.

        // Iterating through the set (sorted order)
        System.out.println("Contents of ConcurrentSkipListSet (sorted):");
        for (Integer number : skipListSet) {
            System.out.println(number);  // Output: 10, 20, 30 (sorted and no duplicates)
        }

        // Concurrent modification
        System.out.println("Adding elements concurrently:");
        Runnable task = () -> {
            for (int i = 40; i <= 50; i += 10) {
                skipListSet.add(i);
                System.out.println("Added: " + i);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        // Waiting for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display final set contents
        System.out.println("Final contents of ConcurrentSkipListSet:");
        for (Integer number : skipListSet) {
            System.out.println(number);
        }
    }

    // Testing ConcurrentLinkedQueue
    public static void testConcurrentLinkedQueue() {
        // ConcurrentLinkedQueue is a lock-free thread-safe queue.
        System.out.println("\nTesting ConcurrentLinkedQueue:");

        // Creating a ConcurrentLinkedQueue
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        // Adding elements to the queue
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");

        // Polling from the queue (thread-safe)
        System.out.println("Poll from queue: " + queue.poll());  // Output: Apple ( removes element

        // Peeking the head of the queue
        System.out.println("Peek from queue: " + queue.peek());  // Output: Banana

        // Removing an element
        queue.remove("Banana");
        System.out.println("Queue after removing 'Banana': " + queue);  // Output: [Cherry]
    }

    // Testing ConcurrentSkipListMap
    public static void testConcurrentSkipListMap() {
        // ConcurrentSkipListMap is a thread-safe map based on a skip list.
        System.out.println("\nTesting ConcurrentSkipListMap:");

        // Creating a ConcurrentSkipListMap
        ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();

        // Putting values into the map
        skipListMap.put("A", 1);
        skipListMap.put("B", 2);
        skipListMap.put("C", 3);

        // Traversing the map (sorted order)
        System.out.println("Contents of ConcurrentSkipListMap:");
        skipListMap.forEach((key, value) -> System.out.println(key + " = " + value));

        // Retrieving a value
        System.out.println("Value for key 'B': " + skipListMap.get("B")); // Output: 2
    }

    // Testing ConcurrentLinkedDeque
    public static void testConcurrentLinkedDeque() {
        // ConcurrentLinkedDeque is a thread-safe deque (double-ended queue).
        System.out.println("\nTesting ConcurrentLinkedDeque:");

        // Creating a ConcurrentLinkedDeque
        Deque<String> deque = new ConcurrentLinkedDeque<>();

        // Adding elements to the deque (thread-safe)
        deque.addFirst("Apple");
        deque.addLast("Banana");
        deque.addFirst("Cherry");

        // Iterating through the deque
        System.out.println("Contents of ConcurrentLinkedDeque:");
        for (String fruit : deque) {
            System.out.println(fruit);  // Output: Cherry, Apple, Banana
        }

        // Removing elements from the deque
        System.out.println("Remove first: " + deque.removeFirst());  // Output: Cherry
        System.out.println("Remove last: " + deque.removeLast());    // Output: Banana
    }


}
