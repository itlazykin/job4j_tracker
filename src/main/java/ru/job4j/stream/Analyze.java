package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Вычисляет общий средний балл.
     * - flatMap() для преобразования в поток объектов Subject;
     * - mapToInt() для последующего преобразования в поток оценок по каждому предмету;
     * - average() для расчета среднего бала по предмету;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     *
     * @param stream поток
     * @return результат
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::scope)
                .average()
                .orElse(0d);
    }

    /**
     * Вычисляет средний балл по каждому ученику.
     * То есть берем одного ученика и считаем все его баллы за все предметы и делим на количество предметов.
     * Возвращает список из объекта Tuple (имя ученика и средний балл).
     * - метод map() для преобразования в поток объектов класса Tuple,
     * внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * - при этом в конструктор первым параметром будет передаваться
     * имя текущего объекта Pupil - используем соответствующий геттер;
     * - вторым параметром рассчитанный средний балл - расчет можно произвести по той же последовательности,
     * что описана для метода averageScore;
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     *
     * @param stream поток
     * @return результат
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.name(), pupil.subjects()
                        .stream()
                        .mapToDouble(Subject::scope)
                        .average()
                        .orElse(0d)))
                .collect(Collectors.toList());
    }

    /**
     * Вычисляет средний балл по каждому предмету.
     * Например, собираем все баллы учеников по предмету география и делим на количество учеников.
     * Возвращает список из объектов Tuple (название предмета и средний балл).
     * Реализация этого метода несколько сложна,
     * поскольку в данном случае требуется выполнить промежуточный сбор данных в Map(). Опишем вкратце алгоритм:
     * - flatMap() для преобразования в поток объектов Subject;
     * - метод collect() в который мы передаем метод groupingBy() (с тремя параметрами) класса Collectors.
     * При этом карта собирается следующим образом: ключ (первый параметр) - это имя предмета.
     * Второй параметр - тип карты, который будем использовать
     * (в нашем случае нужен LinkedHashMap::new, хранит пары ключ-значение в порядке поступления),
     * значение карты (третий параметр) - средний балл по этому предмету для каждого ученика.
     * Для расчета среднего балла используйте метод averagingDouble() класса Collectors;
     * - после этого собранную карту мы разбираем с помощью entrySet() и открываем поток с помощью stream();
     * - полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
     * внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * - в конструктор мы будем передавать параметры с помощью методов getKey() и getValue() интерфейса Entry;
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     *
     * @param stream поток
     * @return список из объектов Tuple
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects()
                        .stream())
                .collect(Collectors.groupingBy(
                        Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::scope)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Возвращает лучшего ученика. Лучшим считается ученик с наибольшим суммарным баллом по всем предметам.
     * Возвращает объект Tuple (имя ученика и суммарный балл).
     * Для реализации данного метода можно использовать метод averageScoreByPupil за исключением следующих особенностей:
     * - в данном методе мы рассчитываем суммарный балл,
     * а не средний - поэтому вместо average() нужно использовать метод sum();
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     * в который будем передавать компаратор.
     * При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     *
     * @param stream поток
     * @return объект Tuple
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects()
                        .stream()
                        .mapToInt(Subject::scope)
                        .sum()))
                .max(Comparator.comparing(Tuple::scope))
                .orElse(null);
    }

    /**
     * Возвращает предмет с наибольшим баллом для всех студентов.
     * Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету).
     * Для реализации данного метода можно использовать метод averageScoreBySubject
     * за исключением следующих особенностей:
     * - в данном методе мы рассчитываем суммарный балл,
     * а не средний - поэтому вместо averagingDouble() нужно использовать метод summingDouble();
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     * в который будем передавать компаратор.
     * При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     *
     * @param stream поток
     * @return объект Tuple
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects()
                        .stream())
                .collect(Collectors.groupingBy(Subject::name, Collectors.summingDouble(Subject::scope)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparing(Tuple::scope))
                .orElse(null);
    }
}
