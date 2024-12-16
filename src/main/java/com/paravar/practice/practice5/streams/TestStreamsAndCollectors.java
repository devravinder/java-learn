package com.paravar.practice.practice5.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestStreamsAndCollectors {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("A", 1),
                new User("B", 2),
                new User("C", 3),
                new User("D", 4),
                new User("E", 5),
                new User("A", 1),
                new User("B", 2)
        );

        printAllUsers(users);
        printAllUserNames(users);
        printAllUsersLessAge(users, 3);
        collectAndThen(users);
        printDistinctUsersByName(users);
        sortUsers(users);

        skipLimitDropTake(users);

        reduce(users); // *** Imp

        minMaxCount(users);

        allMatchAnyMatchNoneMatch(users);

        findFirstFindAny(users);

        groupByName(users);

    }


    public static void printAllUsers(List<User> users) {
        System.out.println(" Print all Users ");
        //users.stream().forEach(System.out::println);
        users.forEach(System.out::println);
    }

    public static void printAllUserNames(List<User> users) {

        System.out.println(" Print all user names ");
        //users.stream().forEach(System.out::println);

        //List<String> names = users.stream().map(User::getName).collect(Collectors.toList());

        List<String> names = users.stream().map(User::getName).toList();
        System.out.println(names);

    }

    public static void printAllUsersLessAge(List<User> users, int age) {
        System.out.println(" printAllUsersLessAge ");


        List<User> youngers = users.stream().filter(u -> u.age < age).collect(Collectors.toList());

        System.out.println("youngers " + youngers);
    }

    public static void collectAndThen(List<User> users) {
        String countMessage = users.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.counting(),
                        count -> " Total count: " + count
                ));
        System.out.println(countMessage);

    }

    public static void printDistinctUsersByName(List<User> users) {
        // based on hashcode & equals
        List<User> distinct = users.stream().distinct().collect(Collectors.toList());
        System.out.println(" distinct users " + distinct);


        // Distinct by name (custom uniqueness)
        List<User> distinctByName = users.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                User::getName,  // Key: User name
                                user -> user,   // Value: Full User object
                                (existing, replacement) -> existing // Merge: Keep the first one
                        ),
                        map -> new ArrayList<>(map.values()) // Convert Map to List
                ));

        System.out.println("Distinct Users by Name:");
        distinctByName.forEach(System.out::println);

    }

    public static void sortUsers(List<User> users) {
        System.out.println(" sorting ");

        List<User> sortedUsers = users.stream().sorted(Comparator.comparingInt(User::getAge)).toList();

        System.out.println("sortedUsers " + sortedUsers);

        System.out.println(" sort users by age ");
        users.sort(Comparator.comparingInt(User::getAge)); // sorts the list

        System.out.println(users);

    }

    private static void skipLimitDropTake(List<User> users) {
        var after2 = users.stream().skip(2).toList(); // off set

        var till2 = users.stream().limit(2).toList();

        var elders = users.stream().dropWhile(u -> u.getAge() < 2).toList();

        var younger = users.stream().takeWhile(u -> u.getAge() < 2).toList();

        System.out.println("after 2 " + after2);
        System.out.println("till 2 " + till2);
        System.out.println(" younger " + younger);
        System.out.println("elders " + elders);
    }

    private static void reduce(List<User> users) {
        System.out.println(" reduce ");

        User elder = users.stream().reduce((pre, cur) -> pre.getAge() > cur.getAge() ? pre : cur).orElse(null);

        System.out.println(" elder " + elder);


        String allNames = users.stream().map(User::getName).reduce("", (pre, cur) -> pre + " " + cur);


        // This version is designed for parallel streams.
        // It uses an identity value, an accumulator, and a combiner.

        /*
         Accumulator:
           The accumulator is a function that processes each element in the stream
            and combines it with a running result.

           Input Parameters: (partialResult, element)


         Combiner:
           The combiner is a function that merges partial results from different threads
             when processing in parallel.

           Input Parameters: (result1, result2)

        * */

        String allNames2 = users.stream().reduce("", (p, c) -> p + " " + c.getName(), (str1, str2) -> str1 + str2);

        System.out.println(" all Names 1 " + allNames);
        System.out.println(" all names 2 " + allNames2);


    }

    private static void minMaxCount(List<User> users) {
        User minAge = users.stream().min(Comparator.comparingInt(User::getAge)).orElse(null);
        User minAge2 = users.stream().min((f, s) -> f.getAge() - s.getAge()).orElse(null);
        System.out.println("min age " + minAge);
        System.out.println("min age " + minAge2);

        User maxAge = users.stream().max(Comparator.comparingInt(User::getAge)).orElse(null);

        System.out.println("max age " + maxAge);

        long younger = users.stream().filter(u -> u.getAge() < 2).count();

        System.out.println(" younger " + younger);


    }

    private static void allMatchAnyMatchNoneMatch(List<User> users) {
        boolean allMatch = users.stream()
                .allMatch(user -> user.getAge() < 20);

        System.out.println("Are all users older than 20? " + allMatch);


        boolean anyMatch = users.stream()
                .anyMatch(user -> user.getAge() > 4);

        System.out.println("Does any user have a age > 4? " + anyMatch);


        boolean noneMatch = users.stream()
                .noneMatch(user -> user.getAge() > 20);

        System.out.println("Does no user have age > 20? " + noneMatch);
    }

    private static void findFirstFindAny(List<User> users) {

        User younger = users.stream().filter(u -> u.getAge() < 2).findFirst().orElse(null);
        System.out.println(" younger " + younger);

        User older = users.stream().filter(u -> u.getAge() > 3).findAny().orElse(null);
        System.out.println(" Older " + older);
    }

    private static void groupByName(List<User> users) {

        Map<String, Long> userCountByName = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.counting()));

        System.out.println("userCountByName " + userCountByName);

        Map<String, List<User>> usersByName = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.toList()));

        System.out.println("usersByName " + usersByName);

        Map<Integer, Integer> ageSums = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.summingInt(User::getAge)));

        System.out.println(" ageSums " + ageSums);


        System.out.println(" custom Grouping by collector ");

        Map<Integer, Integer> ageSums2 = users.stream().collect(Collectors.groupingBy(User::getAge, customSum(User::getAge)));

        System.out.println(" ageSums2 " + ageSums2);




    }

    public static Collector<User, ?, Integer> customSum(Function<? super User, Integer> mapper) {
        return Collector.of(
                () -> new int[1], // Supplier: Create an array to store the sum
                (acc, user) -> acc[0] += mapper.apply(user), // Accumulator: Add the mapped value to the sum
                (acc1, acc2) -> { // Combiner: Combine sums from parallel streams
                    acc1[0] += acc2[0];
                    return acc1;
                },
                acc -> acc[0] // Finisher: Return the final sum as an Integer
        );
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
        if (this == o) return true;
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
        return "{" + "name=" + name + ", age=" + age + "}";
    }
}