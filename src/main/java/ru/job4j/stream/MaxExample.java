package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxExample {
    public static void main(String[] args) {
        System.out.println("- max() - возвращает максимальный элемент потока."
                + " Наибольший элемент определяется с помощью компаратора, который передается в параметр метода. "
                + "Работает аналогично методу min().");
        List<Integer> list = Arrays.asList(4, 5, 1, 3, 2, -1);
        Optional<Integer> maxEl = list.stream()
                .max(Comparator.naturalOrder());
        System.out.println(maxEl.get());
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        Optional<Person> oldestPerson = people.stream()
                .max(Comparator.comparing(Person::age));
        int age = oldestPerson.get().age();
        System.out.println(age);
    }
}
