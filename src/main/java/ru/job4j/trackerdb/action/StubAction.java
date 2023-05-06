package ru.job4j.trackerdb.action;

import ru.job4j.trackerdb.input.Input;
import ru.job4j.trackerdb.store.Store;

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