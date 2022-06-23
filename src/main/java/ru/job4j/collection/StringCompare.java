package ru.job4j.collection;

import java.util.Comparator;

import static java.lang.Math.abs;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = Integer.compare(left.length(), right.length());
        if (rsl == -1) {
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    return Character.compare(left.charAt(i), right.charAt(i));
                }
            }
        } else {
            for (int i = 0; i < right.length(); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    return Character.compare(left.charAt(i), right.charAt(i));
                }
            }
        }
        return rsl;
    }
}
