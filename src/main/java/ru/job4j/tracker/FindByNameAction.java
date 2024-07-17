package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Search for a request by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Search for a request by name ===");
        String name = input.askStr(" Enter name ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Application " + name + " was not found");
        }
        return true;
    }
}
