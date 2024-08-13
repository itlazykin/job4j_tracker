package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MapToIntExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        strings.stream()
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        System.out.println();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        integers.stream()
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
        System.out.println();
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Катя", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .filter(e -> e.age() > 25)
                .mapToInt(Person::age)
                .peek(System.out::println)
                .sum();
        System.out.println("Sum: " + sum);
    }
}
