package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.model.Item;
import ru.job4j.tracker_db.store.MemTracker;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.store.Store;

import java.util.List;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
        return true;
    }
}
