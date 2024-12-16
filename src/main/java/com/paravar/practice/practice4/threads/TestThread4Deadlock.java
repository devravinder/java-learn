package com.paravar.practice.practice4.threads;

public class TestThread4Deadlock {
    public static void main(String[] args) {

        Object resource1 = new Object();
        Object resource2 = new Object();


       Thread t1 = new Thread(()->{
          synchronized (resource1){
              System.out.println(" t1 acquired resource1");
              // Thread.sleep(100);
              synchronized (resource2){
                  System.out.println(" t2 acqyired resource2");
              }
          }
        });

        Thread t2 = new Thread(()->{
            synchronized (resource2){
                System.out.println(" t1 acquired resource2");
                // Thread.sleep(100);
                synchronized (resource1){
                    System.out.println(" t2 acqyired resource1");
                }
            }
        });

        t1.start();
        t2.start();

    }
}

class Job implements Runnable {
    @Override
    public void run() {
        System.out.println(" in child 1");
        synchronized (this){
            System.out.println("in child 2");
        }

    }
}