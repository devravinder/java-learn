package com.paravar.practice.practice5.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestCollectors {
    public static void main(String[] args) {
        /*
         Collectors:-
            - utility methods for processing elements of a stream and producing complex results
                - useful while grouping or collecting

         Types:-
          1. Aggregating Collectors
             - counting(): Counts the number of elements in the stream.
             - summingInt(), summingLong(), summingDouble(): Calculates the sum of elements.
             - averagingInt(), averagingLong(), averagingDouble(): Computes the average of elements.
             - maxBy(), minBy(): Finds the maximum or minimum element based on a comparator.

          2. Grouping Collectors
              - groupingBy(): Groups elements by a classifier function.
              - groupingByConcurrent(): A concurrent variant of groupingBy for parallel streams.

          3. Partitioning Collectors
             - partitioningBy(): Partitions elements into two groups based on a predicate.

          4. Reducing Collectors
             - reducing(): Performs a reduction on the elements of the stream.

          5. Joining Collectors
            joining(): Concatenates elements into a single String.
                - joining() – No delimiter.
                - joining(delimiter) – Delimiter between elements.
                - joining(delimiter, prefix, suffix) – Delimiter with prefix and suffix.

           6. Mapping Collectors
                - mapping(): Transforms the elements before collecting.

           7. Miscellaneous Collectors
                - toList(): Collects elements into a List.
                - toSet(): Collects elements into a Set.
                - toMap(): Collects elements into a Map.
                - toCollection(): Collects elements into a specific collection (e.g., LinkedList)

           8. Two-Step Transform
               - collectingAndThen
                        to perform a two-step transformation when collecting stream elements
                 takes two args
                   - Collector:
                            Applies an intermediate collection step
                            using another collector (e.g., toList(), toSet(), toMap()).
                   - Finisher Function:
                            Applies a transformation (post-processing) to the result of the first collector.

        * */

        groupBy();
        mapping();
        reducing();
        collectingAndThen();


    }
    private static void groupBy(){
        // Classifier function: decides how elements are grouped - classifies
                              // this produces key for Map


        // Downstream Collector: is a collector that processes grouped elements after they've been classified
            // in Collectors.groupingBy()
            // Decides what to do with items in each group.


        // Supplier : is function that takes arg (in general)
            // decides which kind of Map to use for storing the groups ( in group by )

           // default supplier is HashMap

        List<String> words = List.of("Hi",
                "Hello",
                "How",
                "are",
                "you?",
                "Hi",
                "Thanks",
                "are",
                "you",
                "Ok.",
                "Hello");

        // =============== 1. only Classifier  as Key

        Map<String, List<String>> wordsMap = words.stream()
                .collect(Collectors.groupingBy(Function.identity()));
        System.out.println("wordsMap "+wordsMap);

        //---


        Map<Character, List<String>> groupedByFirstChar = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));  // <-- classifier


        System.out.println("groupedByFirstChar "+groupedByFirstChar);



        // ============= 2. Classifier + Downstream Collector
        Map<String, Long> occurrensces = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("occurrensces "+occurrensces);


        Map<Integer, String> lengthWords = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.joining(", ")
                ));

        System.out.println("lengthWords "+lengthWords);


        // ========== 3. Classifier + Supplier + Downstream Collector

        Map<String, Long> occurrences = words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),               // classifier
                        TreeMap::new,                      // custom map supplier
                        Collectors.counting()              // downstream collector
                ));

        System.out.println("occurrences 2 "+occurrences);
    }

    private static void mapping(){

        //============= 1
        List<String> names = List.of("alice", "bob", "anna", "brad");

        Map<Character, List<String>> result = names.stream()
                .collect(Collectors.groupingBy(
                        name -> name.charAt(0),             // Group by first character
                        Collectors.mapping(String::toUpperCase,   // Map each name to uppercase
                                Collectors.toList())              // Collect as list
                ));

        System.out.println(result);

        // ================ 2  *******

        String str = "Hi Hello How are you? Hi Thanks are you Ok. Hello";

        Map<String, Long> wordsCount= Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


       Map<Long, List<String>> groupByCount =  wordsCount.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey,Collectors.toList()))); // here mapping


        System.out.println("groupByCount "+ groupByCount);

    }

    private static void reducing(){
        // ========== 1
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // we can use reduce
        int sum = numbers.stream()
                .collect(Collectors.reducing(0, Integer::sum));  // identity, accumulator

        System.out.println(sum);


        // =========== 2
        List<String> words = List.of("apple", "banana", "cherry");

        // we can use map & reduce
        int totalLength = words.stream()
                .collect(Collectors.reducing(
                        0,                        // identity
                        String::length,           // mapper function
                        Integer::sum              // combiner
                ));

        System.out.println(totalLength);


    }

    private static void  collectingAndThen(){
        /*
        Collectors.collectingAndThen()
          - It is a decorator collector
          - allows you to apply a finishing transformation after collecting.
        * */

        // ====== 1
        List<String> words = List.of("one", "two", "three");

        String message = words.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.counting(),                     // count elements
                        count -> "Total words: " + count       // format the result
                ));

        System.out.println(message);


        // ======== 2

        String str = "Hi Hello How are you Hi Thanks are you Ok. Hello";

        Map<Long, List<String>> groupByCount = Arrays.stream(str.split(" "))
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                                map -> map.entrySet().stream()
                                        .collect(Collectors.groupingBy(Map.Entry::getValue,
                                                Collectors.mapping(Map.Entry::getKey,Collectors.toList())))
                        )
                );


        System.out.println("groupByCount "+ groupByCount);

    }

}
