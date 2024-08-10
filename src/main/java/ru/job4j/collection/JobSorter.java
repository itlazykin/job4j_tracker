package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        System.out.println();
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("Fix bug", 0)
        );
        jobs.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);
        System.out.println();
        Comparator<Job> combine = new JobDescByNameLength()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobDescByPriority());
        jobs.sort(combine);
        System.out.println();
        System.out.println(jobs);
        System.out.println();
        System.out.println();
        List<Job> job = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        job.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(job);
        Comparator<Job> compareName = (left, right) -> right.name().compareTo(left.name());
        Comparator<Job> comparePriority = (left, right) -> Integer.compare(right.priority(), left.priority());
        Comparator<Job> comb = compareName.thenComparing(comparePriority);
        job.sort(comb);
    }
}
