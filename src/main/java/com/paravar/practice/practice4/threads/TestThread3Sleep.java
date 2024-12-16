package com.paravar.practice.practice4.threads;

public class TestThread3Sleep {
    public static void main(String[] args) {
        try {
        System.out.println(" in main 1");
        Runnable task = ()->{
            System.out.println(" in child thread 1");
            System.out.println(" in child thread 2");

            try {
                Thread.sleep(100);
                System.out.println(" in child thread 3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        };

        new Thread(task).start();
        System.out.println(" main 2");
        Thread.sleep(100);
        System.out.println(" in main 3");

        } catch (InterruptedException e) {
            System.out.println("InterruptedException "+e);
        }

    }
}
