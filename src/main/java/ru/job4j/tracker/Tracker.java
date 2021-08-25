package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    /*private final Item[] items = new Item[100];*/
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        /*items[size++] = item;*/
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < items.size(); index++) {
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
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> keyName = new ArrayList<>();
        for (Item item : items) {
            if (item./*items[i].*/getName().equals(key)) {
                keyName.add(item); /*.items[i]*/
                ;
            }
        }
        return keyName;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
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
            items.set(index, item);/*items[index] = item;*/
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
            /*items[size-1] = null;*/
        }
        return rsl;
    }
}