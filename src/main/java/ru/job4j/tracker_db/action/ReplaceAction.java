package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.model.Item;
import ru.job4j.tracker_db.store.MemTracker;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.store.Store;

import java.time.LocalDateTime;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name, LocalDateTime.now()))) {
            System.out.println("Item is successfully replaced!");
        } else {
            System.out.println("Wrong id!");
        }
        return true;
    }
}
