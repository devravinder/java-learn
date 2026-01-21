package com.paravar.interview;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByOccurrences {
    public static void main(String[] args) {
        String txt = "This is my car and color is red";
        sortByOccurrences(txt);
    }

    public static void sortByOccurrences(String str) {

        Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
                .filter(ch -> !Character.isWhitespace(ch))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var list = map.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
//                .sorted(Map.Entry.comparingByValue())
//                .sorted(Comparator.comparing(Map.Entry::getValue))
//                .sorted((f,s)-> (int)(s.getValue()-f.getValue()))
                .toList();

        System.out.println(list);

    }

}
