package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageExample {
    public static void main(String[] args) {
        System.out.println("- average() - возвращает среднее арифметическое всех элементов потока. "
                + "Применяется только к числовым потокам. "
                + "Метод возвращает OptionalDouble (Значение double, обернутое в Optional). ");
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        System.out.println("Поток объектов Person преобразовывается в поток int "
                + "с последующим подсчетом среднего значения"
                + " среди элементов этого потока с помощью метода average():");
        OptionalDouble average = people.stream()
                .mapToInt(Person::age)
                .average();
        double rsl = average.getAsDouble();
        System.out.println(rsl);
    }
}
