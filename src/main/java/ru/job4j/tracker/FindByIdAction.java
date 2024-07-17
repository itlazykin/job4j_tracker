package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Search for an Item by number";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Search for an Item by number ===");
        int id = input.askInt(" Enter the number ");
        Item item = tracker.findById(id);
        System.out.println(item != null ? "The Item has been found " + item : "Item " + id + " not found");
        return true;
    }
}
