package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class JobTest {
    @Test
    public void whenComparatorByDescNameAndPriority() {
        Comparator<Job> cmpDescNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpDescNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndPriority() {
        Comparator<Job> cmpAcsNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpAcsNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescPriorityAndName() {
        Comparator<Job> cmpDescNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpDescNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByAscPriorityAndName() {
        Comparator<Job> cmpDescNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpDescNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenCmpByDescName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int rsl = cmpDescName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenCmpByDescPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriority();
        int rsl = cmpDescPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenCmpByAscName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int rsl = cmpAscName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenCmpByAscPriority() {
        Comparator<Job> cmpAscPriority = new JobDescByName();
        int rsl = cmpAscPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}