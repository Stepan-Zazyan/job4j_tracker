package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()/*[0]*/.get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceItem(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItem(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenShowAllItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItems(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Show all items" + ln
                + "1. === Exit ===" + ln
                + "=== Show all items ====" + ln
                + item + ln
                + "Menu." + ln
                + "0. Show all items" + ln
                + "1. === Exit ===" + ln));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemById(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find item by id" + ln
                + "1. === Exit ===" + ln
                + "=== Find item by id ====" + ln
                + item + ln
                + "Menu." + ln
                + "0. Find item by id" + ln
                + "1. === Exit ===" + ln));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item name"));
        String name = "New item name";
        Input in = new StubInput(
                new String[]{"0", name, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemsByName(out));
        actions.add(new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find items by name" + ln
                + "1. === Exit ===" + ln
                + "=== Find items by name ====" + ln
                + item + ln
                + "Menu." + ln
                + "0. Find items by name" + ln
                + "1. === Exit ===" + ln));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7", "0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu." + ln
                                + "0. === Exit ===" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu." + ln
                                + "0. === Exit ===" + ln
                )
        );
    }

}