package com.paravar.practice.practice13.completableFeatures;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class TestCompletableFuture {
    public static void main(String[] args) {

        /*

        Use Case
         - Running tasks asynchronously:
             - runAsync(), supplyAsync()
         - Chaining operations:
             - thenApply(), thenAccept(), thenRun()
         - Combining results:
         	 - thenCombine(), allOf(), anyOf()
         - Exception handling:
         	- exceptionally(), handle()
         - Timeout handling:
         	- orTimeout(), completeOnTimeout()
         - Manually completing futures:
         	- complete()
         -Custom thread pools:
         	- Using ExecutorService

        */

        runAsyncExample();
        supplyAsyncExample();
        thenApplyExample();
        thenAcceptExample();
        thenRunExample();
        thenCombineExample();
        allOfExample();
        anyOfExample();
        exceptionallyExample();
        handleExample();
        orTimeoutExample();
        completeExample();
        customExecutorExample();

    }
    public static void runAsyncExample() {
        CompletableFuture.runAsync(() -> System.out.println("Running asynchronously")).join();
    }

    public static void supplyAsyncExample() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        System.out.println(future.join());
    }

    public static void thenApplyExample() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5)
                .thenApply(n -> n * 2);
        System.out.println(future.join()); // Output: 10
    }

    public static void thenAcceptExample() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Test");
        AtomicReference<String> result = new AtomicReference<>();

        future.thenAccept(result::set).join();
        System.out.println(result.get());
    }

    public static void thenRunExample() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Task")
                .thenRun(() -> System.out.println("Finished"));
        future.join();
    }

    public static void thenCombineExample() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combined = future1.thenCombine(future2, Integer::sum);
        System.out.println(combined.join()); // Output: 30
    }

    public static void allOfExample() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "A");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "B");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);
        allFutures.join();
        System.out.println("All tasks completed!");
    }

    public static void anyOfExample() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            return "Slow";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Fast");

        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2);
        System.out.println(anyOf.join()); // Output: Fast
    }

    public static void exceptionallyExample() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if(true)
                throw new RuntimeException("Error occurred");
            return  "Success";
        }).exceptionally(ex -> "Recovered");

        System.out.println(future.join()); // Output: Recovered
    }

    public static void handleExample() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if(true)
                throw new RuntimeException("Error");
            return  "Success";
        }).handle((result, ex) -> ex == null ? result : "Recovered");

        System.out.println(future.join()); // Output: Recovered
    }

    public static void orTimeoutExample() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
            return "Done";
        }).orTimeout(1, TimeUnit.SECONDS);

        try {
            System.out.println(future.join());
        } catch (CompletionException e) {
            System.out.println("Timeout occurred");
        }
    }

    public static void completeExample() {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("Manual Completion");

        System.out.println(future.join()); // Output: Manual Completion
    }

    public static void customExecutorExample() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello", executor);

        System.out.println(future.join()); // Output: Hello
        executor.shutdown();
    }

}
