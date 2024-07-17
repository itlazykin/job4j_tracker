package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Change Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Change Item ===");
        int id = input.askInt(" Enter the number ");
        String name = input.askStr(" Enter the name of the new Item ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println(" The Item has been replaced ");
        } else {
            System.out.println("Item replacement error.");
        }
        return true;
    }
}
