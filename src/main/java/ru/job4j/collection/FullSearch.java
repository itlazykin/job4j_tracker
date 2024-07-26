package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> tasks) {
        HashSet<String> task = new HashSet<>();
        for (Task value : tasks) {
            task.add(value.getNumber());
        }
        return task;
    }
}
