package com.paravar.interview;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q5 {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 2, 6, 1, 7, 8, 8, 9};

        duplicates(numbers);

        duplicates("aabcddef");
    }

    public static void duplicates(Integer[] arr){

       Set<Integer> duplicate =  Arrays.stream(arr)
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e-> e.getValue() > 1)
                .map(e-> e.getKey())
                .collect(Collectors.toSet());

        System.out.println(" duplicate "+ duplicate);

    }

    public static void duplicates(String str){
        Set<Character> duplicates = str.chars() // Convert to IntStream
                .mapToObj(c -> (char) c) // Convert int to Character // ***
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Keep only duplicates
                .map(Map.Entry::getKey) // Extract duplicate characters
                .collect(Collectors.toSet()); // Collect as Set to remove repeated duplicates

        // Print duplicates
        System.out.println("Duplicate Characters: " + duplicates);

    }
}
