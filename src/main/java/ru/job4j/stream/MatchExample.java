package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        System.out.println("Методы проверки элементов на соответствие заданному условию "
                + "- noneMatch(), anyMatch() и allMatch()."
                + "Все эти методы принимают Predicate в качестве параметра (условия для проверки). "
                + "Также все 3 метода являются конечными (терминальными).");
        System.out.println();
        System.out.println("noneMatch() - возвращает true, если ни один из элементов потока не удовлетворяет условию.");
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result = strings
                .stream()
                .noneMatch("Шесть"::contains);
        System.out.println(result);
        System.out.println();
        System.out.println("anyMatch()-возвращает true, если как минимум 1 из элемов потока удовлетворяет условию. ");
        strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        result = strings.stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(result);
        System.out.println();
        System.out.println("allMatch() - возвращает true, если все элементы потока удовлетворяют условию. ");
        strings = Arrays.asList("Один", "Одиннадцать", "Одинокий", "Одиндиндин", "ОдинОПять");
        result = strings.stream()
                .allMatch(element -> element.startsWith("Оди"));
        System.out.println(result);
    }
}
