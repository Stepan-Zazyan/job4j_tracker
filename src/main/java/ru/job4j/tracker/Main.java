package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(2,"AAA"),
                new Item(1,"BBB"),
                new Item(3,"CCC")
        );
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        Collections.sort(items, Collections.reverseOrder());
        System.out.println(items);
    }
}
