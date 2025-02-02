package ru.job4j.tracker.action;

import ru.job4j.tracker1.Output;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.model.Item;

public class CreateManyItems implements UserAction {
    private Output out;

    public CreateManyItems() {
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        System.out.println("=== Create many items ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
            if (i % 1000 == 0) {
                System.out.println("Добавлено заявок: " + i);
            }
        }
        System.out.println("Добавление заявок выполнено: " + count);
        return true;
    }
}
