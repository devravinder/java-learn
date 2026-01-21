package com.paravar.practice.practice9.functionalInterfaces;

import java.util.List;
import java.util.function.*;

public class TestFunctionalInterfaces {
    public static void main(String[] args) {
        /*
          FunctionalInterface:-
            - interface with only one abstract method
            - it can have any no of default & static methods
            - it can have static variables as well

            - @FunctionalInterface  annotation is used to mark interface as FI
               - not required/mandatory ...but for readability
                 - so compiler won't allow further...abstract methods


             - There are many builtin FIs

               - Predicate
               - Function
               - Consumer
               - Supplier
               - UnaryOperator
               - BinaryOperator

        * */

        ex1();

        // takes T & returns boolean
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        System.out.println(isEven.test(4)); // true

        // takes T & returns R
        Function<String, Integer> stringLength = (s) -> s.length();  // <arg,return>
        System.out.println(stringLength.apply("Hello")); // 5



        // takes T & returns void
        Consumer<String> printMessage = (msg) -> System.out.println(msg); // <argtype>
        printMessage.accept("Hello, World!"); // Prints: Hello, World!


        // takes no arg & returns R
        Supplier<Double> randomValue = () -> Math.random(); //
        System.out.println(randomValue.get()); // Random value between 0.0 and 1.0

        // same arg & return type & only 1 arg
        UnaryOperator<Integer> square = (x) -> x * x; // it is like function... arg type & return type are sane
        System.out.println(square.apply(5)); // 25

        // same arg & return type & 2 args
        BinaryOperator<Integer> add = (x, y) -> x + y; // function ...with both args & return types are same
        System.out.println(add.apply(5, 10)); // 15


        MyFunction multiply = (a, b) -> a * b;

        // Using the method
        System.out.println("Multiplication result: " + multiply.multiply(5, 10));  // 50

        System.out.println(multiply.description());






    }

    public static void ex1(){
        List<String> names = List.of("Ravinder", "Reddy", "Kothabad", "Developer", "Java");

        Predicate<String> startsWithR = (String s)-> s.startsWith("R");
        Function<String, String> toUpperCase = String::toUpperCase;
        Consumer<String> print = System.out::println;
        Supplier<String> notFound = ()->"No names found";

        //
        names.stream()
                .filter(startsWithR)
                .map(toUpperCase)
                .findFirst()
                .ifPresentOrElse(print, // consumer
                        ()->{
                            print.accept(notFound.get());
                        });


    }
}

@FunctionalInterface
interface MyFunction {
    // Single abstract method
    int multiply(int a, int b);

    // Default method (not required, but allowed)
    default String description() {
        return "This is a custom functional interface";
    }
}
