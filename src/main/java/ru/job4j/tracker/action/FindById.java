package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class FindById implements UserAction {
    private final Output output;

    public FindById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Search for an Item by number";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Search for an Item by number ===");
        int id = input.askInt(" Enter the number ");
        Item item = tracker.findById(id);
        output.println(item != null ? "The Item has been found " + item : "Item " + id + " not found");
        return true;
    }
}
