package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;

import static org.assertj.core.api.Assertions.*;

class StartUITest {
    String ln = System.lineSeparator();

    @Test
    void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new Delete(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Change Item" + ln
                        + "1. Exit program" + ln
                        + "=== Change Item ===" + ln
                        + " The Item has been replaced " + ln
                        + "Menu:" + ln
                        + "0. Change Item" + ln
                        + "1. Exit program" + ln
                        + "Goodbye" + ln
        );
    }

    @Test
    void whenFindAllActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find of all Items" + ln
                        + "1. Exit program" + ln
                        + "=== Find of all Items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find of all Items" + ln
                        + "1. Exit program" + ln
                        + "Goodbye" + ln
        );
    }

    @Test
    void whenFindByNameActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(one.getName()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Search for a request by name" + ln
                        + "1. Exit program" + ln
                        + "=== Search for a request by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Search for a request by name" + ln
                        + "1. Exit program" + ln
                        + "Goodbye" + ln
        );
    }

    @Test
    void whenFindByIdActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Search for an Item by number" + ln
                        + "1. Exit program" + ln
                        + "=== Search for an Item by number ===" + ln
                        + "The Item has been found " + one + ln
                        + "Menu:" + ln
                        + "0. Search for an Item by number" + ln
                        + "1. Exit program" + ln
                        + "Goodbye" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit program" + ln
                        + "Incorrect input, you can choose: 0..0" + ln
                        + "Menu:" + ln
                        + "0. Exit program" + ln
                        + "Goodbye" + ln
        );
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit program" + ln
                        + "Goodbye" + ln
        );
    }
}