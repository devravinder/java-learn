package com.paravar.practice.practice12.singleton;

public class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
 class Singleton {
    // Volatile instance variable
    private static volatile Singleton instance;

    // Private constructor
    private Singleton() {
        // Prevent reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance.");
        }
    }

    // Public method to provide the single instance
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
