package ru.job4j.collectionUsage;

import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Petr");
        list.add("Ivan");
        list.add("Stepan");
        for (Object value: list) {
            System.out.println(value);
        }
    }
}
