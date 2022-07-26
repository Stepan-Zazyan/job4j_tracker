package ru.job4j.map;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        List<Pupil> pupils = Arrays.asList(
                new Pupil("Ivanov",
                        List.of(
                                new Subject("Math", 70),
                                new Subject("Lang", 90),
                                new Subject("Philosophy", 100)
                        )
                ),
                new Pupil("Petrov",
                        List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60),
                                new Subject("Philosophy", 60)
                        )
                ),
                new Pupil("Sidorov",
                        List.of(
                                new Subject("Math", 80),
                                new Subject("Lang", 60),
                                new Subject("Philosophy", 50)
                        )
                )
        );
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                map.putIfAbsent(subject.getName(), 0);
                for (Map.Entry<String, Integer> x : map.entrySet()) {
                    if (subject.getName().equals(x.getKey())) {
                        map.put(x.getKey(), map.get(x.getKey()) + subject.getScore());
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            label.add(new Label(x.getKey(), x.getValue() / pupils.size()));
        }
        System.out.println(map);
        System.out.println(map.get("Math") + 20);
        System.out.println(label);
        for (Pupil pupil : pupils) {
            List<Subject> subj = new ArrayList<>();
            for (Subject sub : subj) {
                map.put(sub.getName(), sub.getScore());
            }
        }
        LinkedHashMap<String, Integer> checkMap = new LinkedHashMap<>();
        checkMap.put("1", 1);
        checkMap.put("2", 2);
        checkMap.put("3", 3);
        System.out.println(checkMap);
        checkMap.put("3", checkMap.get("3") + 1);
        checkMap.computeIfPresent("2", (t,u)-> u+2);
        System.out.println(checkMap);
    }
}
