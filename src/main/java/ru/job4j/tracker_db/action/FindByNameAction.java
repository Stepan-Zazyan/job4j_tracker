package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.model.Item;
import ru.job4j.tracker_db.store.MemTracker;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.store.Store;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        for (Item item: items) {
            System.out.println(item);
        }
        return true;
    }
}
