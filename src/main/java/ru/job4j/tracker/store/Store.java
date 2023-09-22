package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface Store {
    Item add(Item item);

    boolean replace(Integer id, Item item);

    boolean delete(Integer id);

    List<Item> findAll();

    List<Item> findByName(String name);

    Item findById(Integer id);

    void close()  throws SQLException;

}
