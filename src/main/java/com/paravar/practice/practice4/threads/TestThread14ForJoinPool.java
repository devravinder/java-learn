package com.paravar.practice.practice4.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestThread14ForJoinPool {
    public static void main(String[] args) {

        /*
         ForkJoinPool is a high-performance thread pool introduced in Java 7
            - used for divide-and-conquer parallelism.
            - It breaks big tasks into smaller subtasks (fork) and combines results (join).
            - Uses work-stealing algorithm
                - Threads steal tasks from others
                - Better CPU utilization
                - Designed for CPU intensive tasks

            - java8 parallel streams uses ForkJoinPool

         */

        ForkJoinPool pool = new ForkJoinPool();
        int[] arr = {1,2,3,3,44,5,5,6,7,3,};
        long result = pool.invoke(new SumTask(arr, 0, arr.length));

    }
}

class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000;
    int[] arr;
    int start, end;

    SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++)
                sum += arr[i];
            return sum;
        }

        int mid = (start + end) / 2;
        SumTask left = new SumTask(arr, start, mid);
        SumTask right = new SumTask(arr, mid, end);

        left.fork();                // async
        long rightResult = right.compute(); // sync
        long leftResult = left.join();

        return leftResult + rightResult;
    }
}
