package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class Replace implements UserAction {
    private final Output output;

    public Replace(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Change Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Change Item ===");
        int id = input.askInt(" Enter the number ");
        String name = input.askStr(" Enter the name of the new Item ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println(" The Item has been replaced ");
        } else {
            output.println("Item replacement error.");
        }
        return true;
    }
}
