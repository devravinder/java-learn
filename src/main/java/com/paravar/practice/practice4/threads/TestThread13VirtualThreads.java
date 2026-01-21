package com.paravar.practice.practice4.threads;

import java.util.concurrent.Executors;

public class TestThread13VirtualThreads {
    public static void main(String[] args) {
            ex1();
    }

    public static void ex1(){
        Thread vt = Thread.ofVirtual().start(() -> {
            System.out.println("Hello from virtual thread");
        });
        try {
            vt.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void ex2(){
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000_000; i++) {
                executor.submit(() -> {
                    Thread.sleep(1000); // Doesn’t block OS thread
                    return "Done";
                });
            }
        }

    }
}
