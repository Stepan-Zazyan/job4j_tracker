package ru.job4j.stream;

import ru.job4j.map.Pupil;
import ru.job4j.map.Subject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Pupil> pupils = Arrays.asList(
                new Pupil("Ivanov",
                        Arrays.asList(
                                new Subject("Math", 700),
                                new Subject("Lang", 90),
                                new Subject("Philosophy", 100)
                        )
                ),
                new Pupil("Petrov",
                        Arrays.asList(
                                new Subject("Math", 60),
                                new Subject("Lang", 60),
                                new Subject("Philosophy", 60)
                        )
                ),
                new Pupil("Sidorov",
                        Arrays.asList(
                                new Subject("Math", 80),
                                new Subject("Lang", 60),
                                new Subject("Philosophy", 50)
                        )
                )
        );
        pupils.stream()
                .flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1);
        List<Tuple> tuple = pupils.stream()
                .map(s -> new Tuple(s.getName(), (s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(-1))))
                .collect(Collectors.toList());
        List<Tuple> tupleMap = pupils.stream()
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new, Collectors.averagingDouble(
                        Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
        System.out.println(tupleMap);

        Tuple tupleBestSubject = pupils.stream()
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new, Collectors.summingDouble(
                        Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("No tuple found", 0));
        System.out.println(tupleBestSubject);
        Tuple tupleBestStudent = pupils.stream()
                .map(s -> new Tuple(s.getName(), (s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum())))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("No tuple found", 0));
        System.out.println(tupleBestStudent);
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        for (int a : integerList) {
            a += 1;
            System.out.print(a + " ");
        }
        Stream.of(integerList)
                .flatMap(Collection::stream)
                .map(s -> s * 2)
                .forEach(System.out::println);
        List<Integer> integerStream = integerList.stream()

                .map(s -> s * 2)
                .collect(Collectors.toList());
        System.out.println(integerStream);

    }
}
