package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

import java.util.List;

public class FindAll implements UserAction {
    private final Output output;

    public FindAll(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find of all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find of all Items ===");
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("The repository does not contain Items yet");
        }
        return true;
    }
}
