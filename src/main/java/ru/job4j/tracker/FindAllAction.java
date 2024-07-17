package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find of all Items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("The repository does not contain Items yet");
        }
        return true;
    }
}
