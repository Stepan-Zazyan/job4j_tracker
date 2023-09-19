package ru.job4j.tracker1;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);

}
