package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrainingClass {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3);
        System.out.println("map:");
        integers.stream().
                map(x -> x * 2).
                forEach(System.out::print);

        List<Integer> integers2 = Arrays.asList(1, 2, 3);
        System.out.println();
        System.out.println("flatMap:");
        integers2.stream().
                flatMap(x -> Stream.of(4, "a", 7, 6)).
                forEach(System.out::print);

        List<List<Integer>> listOfLists =
                Arrays.asList(Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 2, 3));
        List<Integer> listOflist =
                listOfLists.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
        listOflist.forEach(System.out::println);
    }
}
