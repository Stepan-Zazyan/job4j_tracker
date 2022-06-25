package ru.job4j.collection;

import java.util.Comparator;

/**
 * LexSort
 */
public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split("\\.");
        String[] arrayRight = right.split("\\.");
        int leftNumber = Integer.parseInt(arrayLeft[0]);
        int rightNumber = Integer.parseInt(arrayRight[0]);
        return Integer.compare(leftNumber, rightNumber);
    }
}