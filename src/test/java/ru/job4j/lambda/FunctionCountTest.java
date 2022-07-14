package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionCountTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCount.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultipleFunctionThenMultipleResults() {
        List<Double> result = FunctionCount.diapason(2, 5, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(5D, 10D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionCount.diapason(2, 5, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(5D, 9D, 17D);
        assertThat(result, is(expected));
    }
}