package ru.job4j.collection;

import java.util.*;

import static java.util.Collections.reverse;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String stroka: deps) {
            String start = "";
            for (String element : stroka.split("/")) {
                 tmp.add(start + "/" + element);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}