package ru.job4j.stream;

import java.util.*;
import java.util.stream.IntStream;

public class MinExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 1, 3, 2, -1);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get());
        System.out.println("Компаратор нужно передавать, чтобы метод понимал по какому принципу сравнивать объекты. "
                + "Если метод min() применяется к потоку примитивных чисел,то можно использовать его без компаратора:");
        OptionalInt min = IntStream.rangeClosed(1, 5)
                .min();
        System.out.println(min.getAsInt());
        System.out.println();
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Катя", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparing(Person::age));
        System.out.println("min() возвращает значение типа Optional, поэтому в следующей строке"
                + " мы получаем объект Person из обертки Optional и далее получаем его возраст:");
        int age = youngestPerson.get().age();
        System.out.println(age);
    }
}
