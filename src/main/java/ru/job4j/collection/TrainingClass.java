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
                forEach(System.out::print); // 2, 4, 6

        /*flatMap позволяет заменить элемент на Stream:*/
        List<Integer> integers2 = Arrays.asList(1, 2, 3);
        System.out.println();
        System.out.println("flatMap:");
        integers2.stream().
                flatMap(x -> Stream.of(2, "a", 7, 6)).
                forEach(System.out::print);


        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(1,2,3), Arrays.asList(1,2,3));
        List<Integer> listOflist=
                listOfLists.stream()
                        .flatMap(integers1 -> integers1.stream())
                        .collect(Collectors.toList());
        listOflist.forEach(System.out::println);
    }
}
