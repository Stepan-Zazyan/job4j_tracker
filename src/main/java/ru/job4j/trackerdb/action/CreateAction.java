package ru.job4j.trackerdb.action;

import ru.job4j.trackerdb.model.Item;
import ru.job4j.trackerdb.input.Input;
import ru.job4j.trackerdb.store.Store;

import java.time.LocalDateTime;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name, LocalDateTime.now());
        tracker.add(item);
        System.out.println("Item successfully added!");
        return true;
    }
}
