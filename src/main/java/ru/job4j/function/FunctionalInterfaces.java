package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (t, u) -> map.put(t, u);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");
        System.out.println(map);

        BiPredicate<Integer, String> biPred = (t, u) -> (u.length() == 4 || t % 2 == 0);
        for (Integer i : map.keySet()) {
            System.out.print(biPred.test(i, map.get(i)) + " ");
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (t) -> t.toUpperCase();
        for (String s : sup.get()) {
            func.apply(s);
            con.accept(s);
        }
    }
}