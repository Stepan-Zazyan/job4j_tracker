package ru.job4j.tracker_db.store;

import ru.job4j.tracker_db.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface Store {
    Item add(Item item);
    boolean replace(int id, Item item);
    boolean delete(int id);
    List<Item> findAll();
    List<Item> findByName(String name);
    Item findById(int id);
    void close()  throws SQLException;
}
