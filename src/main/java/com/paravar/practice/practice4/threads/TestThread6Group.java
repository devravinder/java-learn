package com.paravar.practice.practice4.threads;

public class TestThread6Group {
    public static void main(String[] args) {

        /*
         Nowadays, Thread Groups are used less...bcz mostly using Executor Service
        * */

        //systemThreadGroup();
        customThreadGroup();
    }
    public static void systemThreadGroup(){
        ThreadGroup mainTg = Thread.currentThread().getThreadGroup();
        System.out.println("name: "+mainTg.getName());

        ThreadGroup systemTg = mainTg.getParent();
        System.out.println(" name 2: "+systemTg.getName());
    }
    public static void customThreadGroup(){
        Runnable task = ()->{
            String mesage = """
                    Group : %s,
                    Name : %s
                    """.formatted(Thread.currentThread().getThreadGroup(), Thread.currentThread().getName());

            System.out.println(mesage);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ThreadGroup group = new ThreadGroup("MyThreadGroup");

        Thread t1 = new Thread(group, task, "Thread-1");
        Thread t2 = new Thread(group, task, "Thread-2");
        Thread t3 = new Thread(group, task, "Thread-3");

        // Starting the threads
        t1.start();
        t2.start();
        t3.start();

        // Displaying the thread group information
        System.out.println("Thread group name: " + group.getName());
        System.out.println("Active thread count: " + group.activeCount());


        System.out.println();
        // to collect them into array
        Thread[] arr = new Thread[group.activeCount()];
        group.enumerate(arr);

        for (Thread t: arr){
            System.out.println("loop "+ t.getName());
        }



    }
}
