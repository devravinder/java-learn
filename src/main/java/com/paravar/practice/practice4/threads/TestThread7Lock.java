package com.paravar.practice.practice4.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread7Lock {
    public static void main(String[] args) {
        //ex1();
        // ex2();
        ex3();
    }
    public static void ex1(){
        ReentrantLock rtl = new ReentrantLock(true); // fair = give lock to longest waiting thread
        rtl.lock();
        System.out.println(rtl.isLocked());
        System.out.println(rtl.isHeldByCurrentThread());
        System.out.println(rtl.getQueueLength()); // how many threads are in queue
        rtl.lock();
        System.out.println(rtl.getHoldCount());
        rtl.unlock();
        System.out.println(rtl.getHoldCount());
        rtl.unlock();
        System.out.println(rtl.isLocked());
        System.out.println(rtl.isFair());

    }
    public static void ex2(){
            ReentrantLock lock = new ReentrantLock();
            Runnable incrementTask = () -> {
                for (int i = 0; i < 2; i++) {
                    lock.lock(); // Acquire the lock
                    try {
                        System.out.println(Thread.currentThread().getName());
                    } finally {
                        lock.unlock(); // Release the lock in the `finally` block to avoid deadlock
                    }

                    try {
                        Thread.sleep(100); // Simulate some work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            };

            Thread t1 = new Thread(incrementTask, "Thread-1");
            Thread t2 = new Thread(incrementTask, "Thread-2");

            t1.start();
            t2.start();
        }

    public static void ex3(){
        Task1 task1 = new Task1();
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task1, "t2");
        t1.start();
        t2.start();

    }

}

class Task1 implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {

            //if(lock.tryLock(500, TimeUnit.MICROSECONDS))
            if(lock.tryLock()){
                System.out.println(Thread.currentThread().getName()+" got lock");
                for (int i=0; i<2; i++){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
                lock.unlock();
            }else {
                System.out.println(Thread.currentThread().getName()+" didn't got lock");
            }



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}