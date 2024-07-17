package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Search for a request by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Search for a request by name ===");
        String name = input.askStr(" Enter name ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Application " + name + " was not found");
        }
        return true;
    }
}
