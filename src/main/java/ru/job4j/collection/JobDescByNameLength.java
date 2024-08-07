package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByNameLength implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.name().length(), o1.name().length());
    }
}
