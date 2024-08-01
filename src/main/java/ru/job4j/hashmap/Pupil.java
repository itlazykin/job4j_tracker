package ru.job4j.hashmap;

import java.util.List;

/**
 * Класс Pupil описывает ученика.
 *
 * @param name
 * @param subjects
 */
public record Pupil(String name, List<Subject> subjects) {
}
