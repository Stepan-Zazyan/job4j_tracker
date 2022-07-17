package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 101, -5, -2, 0);
        List<Integer> positiveNumbers = numbers.stream()
                        .filter(num -> num > 0)
                        .collect(Collectors.toList());
        positiveNumbers.forEach(System.out::println);
    }
}