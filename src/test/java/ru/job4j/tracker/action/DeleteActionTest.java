package ru.job4j.tracker.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteActionTest {
    @Test
    public void checkDeleteAction() {
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted Item"));
        DeleteAction del = new DeleteAction();
        int firstItemId = tracker.findAll().get(0).getId();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(firstItemId);
        del.execute(input, tracker);
        Assertions.assertTrue(tracker.findAll().isEmpty());
    }
}