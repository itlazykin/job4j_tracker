package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private final LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var i = 0;
        for (var e : tasks) {
            if (e.priority() > task.priority()) {
                break;
            }
            i++;
        }
        this.tasks.add(i, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
