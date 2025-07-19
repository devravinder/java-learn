package com.paravar.practice.practice4.threads;

public class TestThread5Stop {
    public static void main(String[] args) {
        var ex = 2;
        if (ex == 1) {
            ex1();
        } else {
            ex2();
        }
    }

    public static void ex2() {
        try {
            System.out.println(" in main 1");
            Task task = new Task();
            new Thread(task).start();
            Thread.sleep(100);
            task.stop();
            System.out.println(" in main 2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ex1() {
        Thread t = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("in child " + i);
                    Thread.sleep(100);
                }

            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
                Thread.currentThread().interrupt();
                //throw new RuntimeException(e);
            }

        });
        t.start();
        System.out.println(" in main 1");

        // t.stop(); // deprecated // can stop any point
        // potentially leaving shared resources in an inconsistent state.
        t.interrupt();
        System.out.println(" main 2");
    }
}

class Task implements Runnable {
    boolean running = true;

    @Override
    public void run() {
        try {
            int i =0;
            while (running) {
                System.out.println(" in run "+ ++i);

                Thread.sleep(100);

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void stop() {
        this.running = false;
    }
}
