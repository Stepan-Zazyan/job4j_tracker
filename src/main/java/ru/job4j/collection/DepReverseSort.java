package ru.job4j.collection;

import java.util.Comparator;

public class DepReverseSort implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        return t1.compareTo(s);
    }
}
