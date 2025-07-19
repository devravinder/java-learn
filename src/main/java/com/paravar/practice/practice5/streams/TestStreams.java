package com.paravar.practice.practice5.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStreams {
    public static void main(String[] args) {
        /*




        Streams:-
           - java 8 feature
           - to handle iterables in functional programming way

        Types
            - Stream (for working with sequences of objects)
            - IntStream, LongStream, DoubleStream (for working with primitive types)

           By processing:
            - Sequential Stream: Elements are processed one after another.
            - Parallel Stream: Elements are processed in parallel (in multiple threads).

        Creating a Stream:

            - From collections (List, Set, etc.)
            - From arrays
            - From I/O channels
            - Using Stream.of()
            - Using Stream.generate() or Stream.iterate()

      Methods:-
        1. Intermediate Operations:
            These methods return a new stream and are used to transform or filter data.
            They are lazy, meaning they don't perform any computation until a terminal operation is invoked
            - They can be chained with another...more than Operational Streams are allowed

           - filter:
               Filters elements based on a condition (predicate).
           - map:
               Transforms each element to another type or value.
           - flatMap:
               Flattens nested structures into a single stream.
           - distinct:
           	   Removes duplicate elements from the stream.
           - sorted:
           	   Sorts the elements of the stream in natural or custom order.
           - peek:
           	   Allows you to perform an action on each element without modifying the stream.
           	   Useful for debugging.
           - limit:
           	   Truncates the stream to a specified number of elements.
           - skip:
           	   Skips the first n elements of the stream.
           - takeWhile:
           	    Takes elements from the stream while a condition is true
           	    available from Java 9.
           - dropWhile:
           	    Drops elements from the stream while a condition is true,
           	    available from Java 9.


        2. Terminal Operations
           These methods trigger the computation and consume the stream.
            - They can't be chained with another terminal...only one is allowed

          - forEach
              Iterates through each element and performs an action.
          - toArray
          	  Collects the elements into an array.
          - reduce
              Reduces the elements into a single value using an accumulator function.
          - collect
              Collects the elements into a List, Set, Map, or other containers using a Collector.
          - min
          	  Finds the minimum element based on a comparator.
          - max
              Finds the maximum element based on a comparator.
          - count
              Counts the number of elements in the stream.
          - anyMatch
              Returns true if any element matches the given predicate.
          - allMatch
              Returns true if all elements match the given predicate.
          - noneMatch
              Returns true if no elements match the given predicate.
          - findFirst
              Returns the first element in the stream (if present).
          - findAny
              Returns any element from the stream, often used in parallel streams.


       3. Short-Circuiting Operations
            These operations can terminate the processing of the stream early.
          - limit (Intermediate)
          - skip (Intermediate)
          - anyMatch, allMatch, noneMatch, findFirst, findAny (Terminal)

       4. Specialized Stream Methods
            specialized stream types for primitives with specific methods
          - IntStream, LongStream, and DoubleStream.
             These include methods like:
                - sum(): Calculates the sum of elements.
                - average(): Computes the average of elements.
                - range(start, end): Generates a stream of numbers within a range.
                - rangeClosed(start, end): Similar to range, but includes the end value.

       5. Stream Creation Methods
            - Stream.of:	Creates a stream from values or arrays.
            - Arrays.stream:	Converts an array into a stream.
            - List.stream:	Creates a sequential stream from a list.
            - Stream.generate:	Generates an infinite stream of elements based on a supplier.
            - Stream.iterate:
                     Creates an infinite stream of elements starting from a seed,
                     applying a function iteratively.
            - Files.lines:	Reads lines from a file as a stream.



        * */

        interviewQuestions();
        // Creating a list of numbers and words
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1,2, 3,4);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        // Test 1: Filter example
        filterExample(numbers);

        // Test 2: Map example
        mapExample(words);

        // Test 3: Distinct example
        distinctExample(numbers);

        // Test 4: Sorted example
        sortedExample(numbers);

        // Test 5: Reduce example
        reduceExample(numbers);

        // Test 6: ForEach example
        forEachExample(words);

        // Test 7: Parallel Stream example
        parallelStreamExample(numbers);

        // Test 8: Collecting into a List
        collectToListExample(numbers);

        // Test 9: Joining strings
        joiningExample(words);

        // Test 10: GroupingBy example
        groupingByExample(words);
        
        
        duplicateElements(numbers);
        findDuplicateChars("abcdefab");
    }



    // Filter method to filter even numbers
    public static void filterExample(List<Integer> numbers) {
        System.out.println("Test 1: Filter Example");
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);  // Output: [2, 4, 6, 8, 10]
    }

    // Map method to convert strings to their lengths
    public static void mapExample(List<String> words) {
        System.out.println("\nTest 2: Map Example");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Word Lengths: " + wordLengths);  // Output: [5, 6, 6, 4, 3, 5]
    }

    // Distinct method to remove duplicates
    public static void distinctExample(List<Integer> numbers) {
        System.out.println("\nTest 3: Distinct Example");
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Numbers: " + distinctNumbers); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    // Sorted method to sort numbers
    public static void sortedExample(List<Integer> numbers) {
        System.out.println("\nTest 4: Sorted Example");
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Numbers: " + sortedNumbers);  // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    // Reduce method to get the sum
    public static void reduceExample(List<Integer> numbers) {
        System.out.println("\nTest 5: Reduce Example");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);  // Output: 55
    }

    // ForEach method to print each element
    public static void forEachExample(List<String> words) {
        System.out.println("\nTest 6: ForEach Example");
        words.stream()
                .forEach(word -> System.out.println("Word: " + word));
    }

    // Parallel Stream to process elements in parallel
    public static void parallelStreamExample(List<Integer> numbers) {
        System.out.println("\nTest 7: Parallel Stream Example");
        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println("Sum using Parallel Stream: " + sum);  // Output: 55
    }

    // Collecting elements into a List
    public static void collectToListExample(List<Integer> numbers) {
        System.out.println("\nTest 8: Collect to List Example");
        List<Integer> collectedList = numbers.stream()
                .collect(Collectors.toList());
        System.out.println("Collected List: " + collectedList);  // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    // Joining strings
    public static void joiningExample(List<String> words) {
        System.out.println("\nTest 9: Joining Example");
        String result = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined Words: " + result);  // Output: apple, banana, cherry, date, fig, grape
    }

    // GroupingBy example
    public static void groupingByExample(List<String> words) {
        System.out.println("\nTest 10: GroupingBy Example");
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);
        // Output: {3=[fig], 4=[date], 5=[apple, grape], 6=[banana, cherry]}
    }
    private static void duplicateElements(List<Integer> numbers) {
        // Find duplicates using Streams
        Set<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Keep only duplicates
                .map(Map.Entry::getKey) // Extract duplicate keys
                .collect(Collectors.toSet()); // Collect as Set to avoid repeated duplicates

        // Print duplicates
        System.out.println("Duplicate Elements: " + duplicates);
    }


    public static void interviewQuestions(){
        filterDuplicateCharStrings();
    }
    public static void filterDuplicateCharStrings(){
        System.out.println("filterDuplicateCharStrings");
        List<String> strings = Arrays.asList("aaa", "abc", "ccc", "dca", "bbc", "bb", "cbc");
        // out put => "aaa", "ccc", "bbc", "bb","cbc

        // Filter strings that contain duplicate characters
        List<String> filteredStrings = strings.stream()
                .filter(TestStreams::hasDuplicateCharacters)
                .collect(Collectors.toList());

        System.out.println(filteredStrings);
    }
    private static boolean hasDuplicateCharacters(String str) {
        return str.chars()
                .distinct()
                .count() < str.length();
    }

    private static boolean hasDuplicateCharacters2(String str) {
        // Group characters and count their occurrences
        Map<Character, Long> charCounts = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Check if any character has a count greater than 1
        return charCounts.values().stream().anyMatch(count -> count > 1);
    }


    public static void findDuplicateChars(String str){

//        str.chars().collect(Function.identity(), Collectors.counting())

        Set<Character> duplicates =  str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println(duplicates);


    }


}
