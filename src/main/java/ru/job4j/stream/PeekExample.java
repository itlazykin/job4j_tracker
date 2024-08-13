package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<StringBuilder> name = Arrays.asList(
                new StringBuilder("Mickey"),
                new StringBuilder("Jack"),
                new StringBuilder("Den"));
        List<StringBuilder> editNames = name.stream()
                .peek((e -> e.append(" (Student of Job4j)")))
                .sorted()
                .toList();
        System.out.println(editNames);
    }
}
