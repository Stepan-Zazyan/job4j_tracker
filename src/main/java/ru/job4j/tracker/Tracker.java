package ru.job4j.tracker;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] noNullNames = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                noNullNames[size] = items[i];
                size++;
            }
        }
        return noNullNames;
    }

    public Item[] findByName(String key) {
        Item[] keyName = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(key)) {
                keyName[size] = items[i];
                size++;
            }
        }
        return keyName;
    }

}