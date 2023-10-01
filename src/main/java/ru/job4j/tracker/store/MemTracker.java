package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(Integer id) {
        int index = indexOf(id);
        return (index != -1) ? items.get(index) : null;
    }

    @Override
    public void close() throws SQLException {

    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> keyName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                keyName.add(item);
            }
        }
        return keyName;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(Integer id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

/*    public List<Item> sortUp (List<Item> items) {
        Collections.sort(items);
        return items;
    }

    public List<Item> sortDown (List<Item> items) {
        Collections.sort(items, Collections.reverseOrder());
        return items;
    }*/

    public boolean delete(Integer id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

}
