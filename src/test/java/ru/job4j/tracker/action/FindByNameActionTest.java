package ru.job4j.tracker.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {
    @Test
    public void checkFindByNameAction() {
        Store tracker = new MemTracker();
        Item firstItem = new Item("First Item");
        tracker.add(firstItem);
        int firstItemId = tracker.findAll().get(0).getId();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(firstItemId);
        FindByNameAction findByNameAction = new FindByNameAction();
        findByNameAction.execute(input, tracker);
        Assertions.assertEquals(tracker.findAll().get(0), firstItem);
    }
}