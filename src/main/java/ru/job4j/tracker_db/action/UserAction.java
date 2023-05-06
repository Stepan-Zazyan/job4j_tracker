package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.store.Store;

public interface UserAction {
    String name();
    boolean execute(Input input, Store tracker);
}