package com.paravar.practice.practice4.threads;

public class TestThread10ThreadLocal {


    public static void main(String[] args) {
        /*
         ThreadLocal:-
             - to define thread specific local data
             - only thread scope
             - ony objects are allowed ...no primitive values
             - if thread dies...the data is eligible for GC
             - very useful...when thread level data storage required
                 - eg: every request in Servlet...need to store req.Id

             - This data can't be accessed in extended Child thread


         InheritedThreadLocal:-

             - This data can be accessed in Child thread ( passed a copy value )
                - it can modify its own copy of value
                - But the Parent Thread data remain un-effected

        * */

//        ex1();
        ex2();





    }

    public static void ex1(){
        ThreadLocal<Integer> threadLocalVar = new ThreadLocal<>(); //ThreadLocal.withInitial(() -> 1);

        // Main thread setting the value
        System.out.println("Main Thread Initial Value: " + threadLocalVar.get()); // Output: 1

        // Setting the value for the current thread (main thread)
        threadLocalVar.set(100);
        System.out.println("Main Thread Updated Value: " + threadLocalVar.get()); // Output: 100

        Thread childThread = new Thread(()->{
            System.out.println("Child Thread Initial Value: " + threadLocalVar.get()); // Output: 1 (default value)
            threadLocalVar.set(200);
            System.out.println("Child Thread Updated Value: " + threadLocalVar.get()); // Output: 200

        });

        childThread.start();

        try {
            childThread.join(); // Wait for the child thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread value remains unaffected by the child thread
        System.out.println("Main Thread Final Value: " + threadLocalVar.get()); // Output: 100 (main thread's value)


    }

    public static void ex2(){

        InheritableThreadLocal<Integer> inheritedThreadLocalVar = new InheritableThreadLocal<>() {
            @Override
            protected Integer initialValue() {
                return 1; // Default value for parent thread
            }

            // if we don't override childValue...it'll be inherited from parent
            /*
            @Override
             protected Integer childValue(Integer parentValue) {
                return super.initValue()
                return 300;
            }
            */
        };
        System.out.println("Main Thread Initial Value: " + inheritedThreadLocalVar.get()); // Output: 1
        inheritedThreadLocalVar.set(100);
        System.out.println("Main Thread Updated Value: " + inheritedThreadLocalVar.get()); // Output: 100

        // Creating a new thread and accessing the InheritedThreadLocal variable
        Thread childThread = new Thread(() -> {
            System.out.println("Child Thread Value (Inherited from Parent): " + inheritedThreadLocalVar.get()); // Output: 100
            inheritedThreadLocalVar.set(200);
            System.out.println("Child Thread Updated Value: " + inheritedThreadLocalVar.get()); // Output: 200
        });

        childThread.start();

        try {
            childThread.join(); // Wait for the child thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread value remains unaffected by the child thread
        System.out.println("Main Thread Final Value: " + inheritedThreadLocalVar.get()); // Output: 100 (main thread's value)

    }
}
