package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int id = Integer.parseInt(input.askStr(" Enter the number "));
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(item != null ? "The Item was deleted successfully." : "Request deletion error.");
        return true;
    }
}
