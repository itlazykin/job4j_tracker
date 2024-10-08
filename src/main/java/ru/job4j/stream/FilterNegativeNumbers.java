package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-13, 47, 4, 7, 322, 300, 1_000, 1_000_000);
        List<Integer> positive = numbers.stream()
                .filter(num -> num > 0)
                .toList();
        positive.forEach(System.out::println);
    }
}
