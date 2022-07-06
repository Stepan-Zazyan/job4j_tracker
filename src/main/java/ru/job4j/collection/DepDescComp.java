package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 2;
        List<String> oo1 = new ArrayList<>(Arrays.asList(o1.split("/")));
        List<String> oo2 = new ArrayList<>(Arrays.asList(o2.split("/")));
        for (int i = 0; i < Math.min(oo1.size(), oo2.size()); i++) {
            rsl = oo2.get(i).compareTo(oo1.get(i));
            if (rsl == 0) {
                return o1.compareTo(o2);
            } else {
                return rsl;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}