package com.paravar.practice.practice4.threads;

public class TestThread1Wait {
    public static void main(String[] args) {
        try {
            ThreadA threadA = new ThreadA();
            threadA.start();

            synchronized (threadA) {
                System.out.println(" in main 1");

                threadA.wait(); // main threads wait for some change to happen on threadA ( state change )
                // releases lock

                System.out.println(" in man 2");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {

        synchronized (this) {
            System.out.println(" in Thread A 1");
            this.notifyAll();  // current thread notifying all the threads who are waiting on this (ThreadA)
            System.out.println(" in Thread A 2");
        }

    }
}