package ru.job4j.trackerdb.action;

import ru.job4j.trackerdb.model.Item;
import ru.job4j.trackerdb.store.MemTracker;
import ru.job4j.trackerdb.input.Input;
import ru.job4j.trackerdb.store.Store;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Wrong id! Not found");
        }
        return true;
    }
}
