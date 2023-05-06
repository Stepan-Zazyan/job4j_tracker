package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.store.MemTracker;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.store.Store;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exit ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
