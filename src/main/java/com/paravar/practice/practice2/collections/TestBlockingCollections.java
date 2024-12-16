package com.paravar.practice.practice2.collections;
import java.util.concurrent.*;

public class TestBlockingCollections {
    public static void main(String[] args) {
        /*

      Blocking Collection (Queues):-
         - are designed for use in multithreaded environments where one thread can be blocked
            while waiting for a resource to become available

         - These collections can block the thread until a certain condition is met,
            such as waiting for an item to be inserted into the collection
            or for the collection to become non-empty

         - used:
            Producer-Consumer problems, where one thread produces data and another consumes it.
            The producer will be blocked if the queue is full,
             and the consumer will be blocked if the queue is empty

        - Types:
           - LinkedBlockingQueue
           	    - LinkedList (Queue) counter-part
           	    - A thread-safe, optionally bounded queue backed by a linked structure.
           - ArrayBlockingQueue
                - N/A	( no counter-part )
                - A thread-safe, bounded blocking queue backed by an array.
           - PriorityBlockingQueue
               - PriorityQueue
               - A thread-safe priority queue that supports blocking operations.
           - DelayQueue
                - N/A	( no counter-part )
                - A thread-safe, time-based blocking queue for scheduling tasks to execute after a delay.
           - SynchronousQueue
                - N/A
                - A thread-safe, zero-capacity queue where each put() operation must wait for a corresponding take().
           - LinkedTransferQueue
                - N/A
                - A thread-safe, unbounded blocking queue optimized for producer-consumer transfers.
           - BlockingDeque
                - Deque
                - A thread-safe deque supporting blocking operations on both ends.

        */

        testLinkedBlockingQueue();
        testArrayBlockingQueue();
        testPriorityBlockingQueue(); // Very Imp
        testDelayQueue(); // see this Imp also
        testSynchronousQueue();
        testLinkedTransferQueue();
        testBlockingDeque();

    }

    public static void testLinkedBlockingQueue() {
        // LinkedBlockingQueue is a thread-safe, optionally bounded blocking queue.
        System.out.println("\nTesting LinkedBlockingQueue:");

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

        try {
            // Adding elements to the queue
            queue.put("Apple");
            queue.put("Banana");
            queue.put("Cherry");

            // Attempting to add another element will block if the queue is full
            new Thread(() -> {
                try {
                    queue.put("Date");
                    System.out.println("Added Date to the queue.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            // Removing elements from the queue
            while (!queue.isEmpty()) {
                System.out.println("Removed: " + queue.take());
                Thread.sleep(1000); // Simulate processing delay
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testArrayBlockingQueue() {
        // ArrayBlockingQueue is a thread-safe, bounded blocking queue backed by an array.
        System.out.println("\nTesting ArrayBlockingQueue:");

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);

            // This will block because the queue is full
            new Thread(() -> {
                try {
                    queue.put(4);
                    System.out.println("Added 4 to the queue.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            // Consume elements
            while (!queue.isEmpty()) {
                System.out.println("Removed: " + queue.take());
                Thread.sleep(1000); // Simulate processing delay
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testPriorityBlockingQueue() {
        System.out.println("\nTesting PriorityBlockingQueue:");

        // PriorityBlockingQueue with natural ordering (Integer: ascending order)
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(); // optional capacity ( Linked List )

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer adding elements...");
                queue.put(10);
                System.out.println("Added: 10");

                Thread.sleep(1000); // Simulate delay
                queue.put(5);
                System.out.println("Added: 5");

                Thread.sleep(1000); // Simulate delay
                queue.put(20);
                System.out.println("Added: 20");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer retrieving elements...");
                while (true) {
                    System.out.println("Removed: " + queue.take()); // Blocks if queue is empty
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start both threads
        producer.start();
        consumer.start();

        // Wait for threads to finish
        try {
            producer.join();
            Thread.sleep(3000); // Wait for consumer to consume all
            consumer.interrupt(); // Stop consumer  // somehow stop
            // this will throw exception...if the thread is in sleep / wait state...else it'll stop
             // consumer.stop(); deprecated
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testDelayQueue() {
        // DelayQueue is a thread-safe queue where elements must implement Delayed.
        System.out.println("\nTesting DelayQueue:");

        class DelayedElement implements Delayed {
            private final long delayTime;
            private final long expiryTime;
            private final String element;

            public DelayedElement(String element, long delayTime) {
                this.element = element;
                this.delayTime = delayTime;
                this.expiryTime = System.currentTimeMillis() + delayTime;
            }

            @Override
            public long getDelay(TimeUnit unit) {
                return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
            }

            @Override
            public int compareTo(Delayed o) {
                return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
            }

            @Override
            public String toString() {
                return element;
            }
        }

        DelayQueue<DelayedElement> queue = new DelayQueue<>();
        queue.add(new DelayedElement("Task 1", 3000));
        queue.add(new DelayedElement("Task 2", 1000));
        queue.add(new DelayedElement("Task 3", 2000));

        while (!queue.isEmpty()) {
            try {
                DelayedElement element = queue.take(); // Waits for the delay to expire
                System.out.println("Processed: " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testSynchronousQueue() {
        // SynchronousQueue is a thread-safe queue with no capacity.
        System.out.println("\nTesting SynchronousQueue:");

        SynchronousQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                queue.put("Task 1");
                System.out.println("Produced: Task 1");
                queue.put("Task 2");
                System.out.println("Produced: Task 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Consumed: " + queue.take());
                System.out.println("Consumed: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void testLinkedTransferQueue() {
        // LinkedTransferQueue is an unbounded blocking queue optimized for producer-consumer exchange.
        System.out.println("\nTesting LinkedTransferQueue:");

        TransferQueue<String> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                queue.transfer("Message 1");
                System.out.println("Transferred: Message 1");
                queue.transfer("Message 2");
                System.out.println("Transferred: Message 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate delay
                System.out.println("Received: " + queue.take());
                System.out.println("Received: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void testBlockingDeque() {
        // BlockingDeque is a thread-safe deque supporting blocking operations on both ends.
        System.out.println("\nTesting BlockingDeque:");

        BlockingDeque<String> deque = new LinkedBlockingDeque<>();

        try {
            deque.putFirst("Front");
            deque.putLast("Back");

            System.out.println("Removed from front: " + deque.takeFirst());
            System.out.println("Removed from back: " + deque.takeLast());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
