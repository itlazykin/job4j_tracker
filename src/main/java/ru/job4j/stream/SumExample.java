package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SumExample {
    public static void main(String[] args) {
        System.out.println("- sum() - суммирует все элементы потока. Применяется только к числовым потокам."
                + " В данном примере поток объектов Person преобразуется в поток int"
                + " с последующим подсчетом суммы возрастов всех людей в листе:");
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .mapToInt(Person::age)
                .sum();
        System.out.println(sum);
    }
}
