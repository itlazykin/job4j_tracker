package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Delete Item ===");
        int id = Integer.parseInt(input.askStr(" Enter the number "));
        Item item = tracker.findById(id);
        tracker.delete(id);
        output.println(item != null ? "The Item was deleted successfully." : "Request deletion error.");
        return true;
    }
}
