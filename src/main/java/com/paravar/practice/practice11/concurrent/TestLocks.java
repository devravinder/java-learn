package com.paravar.practice.practice11.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class TestLocks {
    public static void main(String[] args) throws InterruptedException {

        /*
         CountDownLatch and CyclicBarrier
           - are synchronization aids in Java's java.util.concurrent package, designed for managing concurrency.

         CountDownLatch:-
           - Used to wait for a set of tasks to complete before proceeding.
           - It provides a one-time event that gets triggered when the count reaches zero.
           - the latch cannot be reused
           - The count is set at the time of initialization and decremented by calling countDown()

           Use Case Example:
            - Waiting for multiple services to initialize before starting an application.

         CyclicBarrier:-
           - Used to synchronize a fixed number of threads, making them wait until
             all threads have reached a common barrier point.

           - Can be reused after all threads reach the barrier, making it cyclic.
           - we can provide a optional barrier action (a task) to execute when all threads reach the barrier.

          Use Case Example:
            - Coordinating threads performing phases of a task
              (e.g., a game level where players must wait until all are ready before starting).


        * */

//        countDownLatch();
        testCyclicBarrier();
    }
    public static void countDownLatch() throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " countDownLatch completed.");
            latch.countDown();
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        latch.await(); // Wait until the count reaches zero.
        System.out.println("CountDownLatch All tasks completed!");

    }
    public static void testCyclicBarrier(){
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All threads reached the barrier."));

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " CyclicBarrier waiting at barrier.");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " CyclicBarrier proceeding.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

    }
}
