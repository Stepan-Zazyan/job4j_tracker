package ru.job4j.collection;

import org.junit.Test;

import java.sql.Array;
import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByNameDown().
                thenComparing(new JobDescByPriorityDown());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProritySecond() {
        Comparator<Job> cmpNamePriority = new JobDescByNameUp().
                thenComparing(new JobDescByPriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 3),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameUp() {
        Comparator<Job> cmpName = new JobDescByNameUp();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDown() {
        Comparator<Job> cmpName = new JobDescByNameUp();
        int rsl = cmpName.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityUp() {
        Comparator<Job> cmpPriority = new JobDescByNameUp();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityDown() {
        Comparator<Job> cmpPriority = new JobDescByNameUp();
        int rsl = cmpPriority.compare(
                new Job("Fix bug", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}