package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static ru.job4j.ex.Fact.calc;

public class FactTest {

    @Test
    public void whenFactorial5Then120() {
        int rsl = calc(5);
        assertThat(rsl, is(120));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenStrangeCheckExIsNeeded() {
        calc(-1);
    }
}