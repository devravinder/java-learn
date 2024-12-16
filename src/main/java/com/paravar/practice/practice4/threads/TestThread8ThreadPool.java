package com.paravar.practice.practice4.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread8ThreadPool {
    public static void main(String[] args) {
        Runnable task = ()->{
            System.out.println(Thread.currentThread().getName()+ " executing");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i=0; i<10; i++){
            executorService.submit(task);
        }
        System.out.println(" main ");
        executorService.shutdown(); // else it'll be waiting for tasks
    }
}
