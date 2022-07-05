package ru.job4j.collection;

import java.util.Arrays;
import java.util.List;

public class TrainingClass {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2/SK1",
                "K1/SK2",
                "K1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        System.out.println(input);
        input.sort(new DepDescComp());
        System.out.println(input);
        input.sort(new DepReverseSort());
        input.sort(new DepDescComp());
        System.out.println(input);
        Departments.fillGaps(input);
        System.out.println(input);
    }
}
