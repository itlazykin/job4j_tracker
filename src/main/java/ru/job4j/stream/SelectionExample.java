package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> skipDemo = strings.stream()
                .skip(2)
                .toList();
        System.out.println(skipDemo);
        strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> limitDemo = strings.stream()
                .limit(3)
                .toList();
        System.out.println(limitDemo);
        strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> skipAndLimit = strings.stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(skipAndLimit);
        strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String findFirstDemo = strings.stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("By default");
        System.out.println(findFirstDemo);
    }
}
