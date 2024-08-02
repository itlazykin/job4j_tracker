package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobsComparable = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobsComparable);
        Collections.sort(jobsComparable);
        System.out.println(jobsComparable);
        System.out.println();
        List<Job> jobsComparator = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobsComparator);
        Collections.sort(jobsComparator);
        System.out.println(jobsComparator);
        jobsComparator.sort(new SortByName());
        System.out.println(jobsComparator);
        System.out.println();
        List<Job> jobsComparatorDescName = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        jobsComparatorDescName.sort(new SortDescByNameJob());
        System.out.println(jobsComparatorDescName);
    }
}
