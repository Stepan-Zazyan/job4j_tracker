package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCount {
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> function = new ArrayList<>();
        for (int i = start; i < end; i++) {
            function.add(func.apply((double) i));
        }
        return function;
    }
}
