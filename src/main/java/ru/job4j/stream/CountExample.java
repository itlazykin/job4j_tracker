package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class CountExample {
    public static void main(String[] args) {
        System.out.println("- count() - возвращает число элементов в потоке.");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        long sum = numbers.stream()
                .filter(e -> e % 2 == 0)
                .count();
        System.out.println(sum);
    }
}
