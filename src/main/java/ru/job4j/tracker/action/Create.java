package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class Create implements UserAction {
    private final Output output;

    public Create(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Create new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Create new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("The Item added: " + item);
        return true;
    }
}
