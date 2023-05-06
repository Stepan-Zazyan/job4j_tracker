package ru.job4j.trackerdb.action;

import ru.job4j.trackerdb.store.MemTracker;
import ru.job4j.trackerdb.input.Input;
import ru.job4j.trackerdb.store.Store;

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
