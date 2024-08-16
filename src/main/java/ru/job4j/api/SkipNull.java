package ru.job4j.api;

import java.util.stream.Stream;

public class SkipNull {
    public static void main(String[] args) {
        System.out.println("ofNullable - сделает из элемента поток, если элемент равен null, то элемент пропускается.");
        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(v -> "Result " + v)
                .forEach(System.out::println);
    }
}
