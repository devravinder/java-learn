package com.paravar.practice.practice4.threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestThread12AtomicValues {

    /*
    operations are performed as a single, indivisible step
      - ensuring thread-safety without explicit synchronization.
    * */

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
//       ex1();
       ex2();
    }
    private static void ex1(){
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.get());
    }

    public static void ex2(){
        AtomicReference<String> sharedMessage = new AtomicReference<>("Initial Message");

        Runnable task1 = () -> {
            String oldValue = sharedMessage.get();
            System.out.println(" task 1: oldValue "+oldValue);
            boolean updated = sharedMessage.compareAndSet(oldValue, "Updated by Task 1");
            // false: if comparison fails
            // while setting...the shared message value should be equal to oldValue else it fails
            System.out.println("Task 1 - Update Successful: " + updated + " | Current Value: " + sharedMessage.get());
        };

        Runnable task2 = () -> {
            String oldValue = sharedMessage.get();
            System.out.println(" task 2: oldValue "+oldValue);
            boolean updated = sharedMessage.compareAndSet(oldValue, "Updated by Task 2");
            // false: if comparison fails
            // while setting...the shared message value should be equal to oldValue else it fails
            System.out.println("Task 2 - Update Successful: " + updated + " | Current Value: " + sharedMessage.get());
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Value: " + sharedMessage.get());
    }
}
