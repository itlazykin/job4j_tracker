package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find of all Items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("The repository does not contain Items yet");
        }
        return true;
    }
}
