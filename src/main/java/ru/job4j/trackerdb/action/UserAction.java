package ru.job4j.trackerdb.action;

import ru.job4j.trackerdb.input.Input;
import ru.job4j.trackerdb.store.Store;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}