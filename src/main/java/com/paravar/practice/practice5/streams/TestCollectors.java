package com.paravar.practice.practice5.streams;

public class TestCollectors {
    public static void main(String[] args) {
        /*
         Collectors:-
            - utility methods for processing elements of a stream and producing complex results

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
    }
}
