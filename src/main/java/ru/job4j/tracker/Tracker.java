package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    /*private final Item[] items = new Item[100];*/
    private ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        /*items[size++] = item;*/
        items.add(item);
        size++;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    /*public Item[] findAll() {
        return Arrays.copyOf(items,size);
    }*/
    public ArrayList<Item> findAll() {
        return items;
    }

    public Item[] findByName(String key) {
        Item[] keyName = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items.get(i)./*items[i].*/getName().equals(key)) {
                keyName[count] = items.get(i)/*.items[i]*/;
                count++;
            }
        }
        return Arrays.copyOf(keyName, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items.get(i)./*items[i]*/getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(id - 1, item);/*items[index] = item;*/
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(id-1);
            /*items[size-1] = null;*/
            size--;
        }
        return rsl;
    }
}