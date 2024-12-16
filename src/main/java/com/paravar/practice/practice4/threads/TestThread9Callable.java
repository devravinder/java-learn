package com.paravar.practice.practice4.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class TestThread9Callable {
    public static void main(String[] args) {
        // ex1();
        // ex2();
        ex3();
    }
    public static void ex1() {

        FutureTask<String> futureTask = new FutureTask<String>(new MessageJob());
        Thread t = new Thread(futureTask);
        t.start();

        try {
            String result = futureTask.get();
            System.out.println(" message "+ result);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ex2(){

        MessageJob task = new MessageJob();
        // Create a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);



        try {
            // Submit the Callable task to the thread pool
            Future<String> future = executorService.submit(task);

            // Do other work here if needed...
            System.out.println("Doing other work while the task is running...");

            // Get the result of the task (blocks if the task isn't done yet)
            String result = future.get();
            System.out.println("Result of the task: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }

    }
    public static void ex3(){

        MessageJob task = new MessageJob();
        // Create a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<MessageJob> tasks = new ArrayList<>(Arrays.asList(task, task, task, task, task));


        try {

            List<Future<String>> futures = executorService.invokeAll(tasks);

            // Get and print results of all tasks
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }

    }


}
class MessageJob implements Callable<String>{
    @Override
    public String call() {
        return "Hello from "+Thread.currentThread().getName();
    }
}
