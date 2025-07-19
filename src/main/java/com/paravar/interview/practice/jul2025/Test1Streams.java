package com.paravar.interview.practice.jul2025;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Test1Streams {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("d40", 40),
                new User("a10", 10),
                new User("b20", 70),
                new User("b20", 30),
                new User("c30", 30),
                new User("f50", 50)
        );

        // users.add(new User("g60", 60));

        System.out.println(users);
        System.out.println("=========");

        reduce(users);

        findDuplicateChars("abcdefab");
        findNonDuplicateChars("abcdefab");
        findUniqueChars("abcdefab");

        noOfOccurrences("Hi Hello How are you? Hi Thanks are you Ok. Hello");


        twoSorts(users);
        get2ndElder(users);


    }

    private static void get2ndElder(List<User> users) {

        User user =  users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .skip(1).limit(1)
                .findFirst().orElse(null);

        System.out.println("2ndYounger "+user);

       User user2 =  users.stream()
               .sorted((f,s)->s.getAge()-f.getAge())
                .skip(1).limit(1)
               .findFirst().orElse(null);

        System.out.println("2ndElder "+user2);

    }

    private static void twoSorts(List<User> users) {
        // first by age then name

      List<User> sorted =   users.stream()
                .sorted(
                        Comparator.comparing(User::getName)
                                .thenComparing(User::getAge)
                ).toList();

        System.out.println(" two sorts "+sorted);

        System.out.println("=======");



    }


    private static void findDuplicateChars(String str){

//        str.chars().collect(Function.identity(), Collectors.counting())

       Set<Character> duplicates =  str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println("duplicates "+duplicates);


    }
    private static void findNonDuplicateChars(String str) {
       Map<Character, Long> map =  str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       Set<Character> nonDuplicates = map.entrySet().stream()
               .filter(e->e.getValue()==1)
               .map(Map.Entry::getKey)
               .collect(Collectors.toSet());

        System.out.println("nonDuplicates "+nonDuplicates);

    }
    private static void findUniqueChars(String str) {

       List<Character> unique = str.chars()
               .distinct().mapToObj(c->(char)c).toList();

        System.out.println("unique "+unique);


        Set<Character> unique2 =  str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.toSet());

        System.out.println("unique2 "+unique2);

    }

    private static void noOfOccurrences(String str){

       Map<String, Long> wordCounts = Arrays.stream(str.split(" "))
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("wordCounts "+wordCounts);


        // *******
        Map<Long, List<String>> groupedByOccurrences = wordCounts.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey,  // downstream: collect words
                                Collectors.toList())
                ));

        System.out.println(groupedByOccurrences);

    }



    public  static  void reduce(List<User> users){


        //-------------

        // Binary operator
        User elder = users.stream().reduce( (pre, cur)->pre.getAge() > cur.getAge() ? pre : cur)
                .orElse(null);

        System.out.println("elder "+ elder);


        User elder2 = users.stream().reduce(null, (pre, cur)-> null == pre ? cur : pre.getAge() > cur.getAge() ? pre : cur);
        System.out.println("elder2 " + elder2);

        // identity(starting value), accumulator, combiner
        // ****
        String allNames = users.parallelStream().reduce("",(pre, cur)->pre + " "+ cur.getName(), (p1,p2)-> p1+p2);
        System.out.println("allNames "+ allNames);
        

        //   int ageSum = users.stream().reduce(0,(pre, cur)-> pre+ cur.getAge(), (partial1,partial2)-> partial1+partial2);
        int ageSum = users.stream().reduce(0,(pre, cur)-> pre+ cur.getAge(), Integer::sum);
                                             // combiner: sum of partial results // used in parallel streams

        System.out.println("ageSum "+ ageSum);
    }


}

 class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}