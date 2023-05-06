package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.store.MemTracker;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.store.Store;

public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}