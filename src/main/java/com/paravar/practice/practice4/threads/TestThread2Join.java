package com.paravar.practice.practice4.threads;

public class TestThread2Join {
    public static void main(String[] args) {
        try {
            System.out.println("in main 1");
            Thread t = new Thread(new Job1());
            t.start();
            t.join(); // current thread wait...until t completes its task
            System.out.println(" in main 2");
        }catch (InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
class Job1 implements Runnable{

    @Override
    public void run() {
        System.out.println(" in Job 1");
        System.out.println(" in Job 2");
    }
}