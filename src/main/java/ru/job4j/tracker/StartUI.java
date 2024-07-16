package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("The Item added: " + item);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Find of all Items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("The repository does not contain Items yet");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Change Item ===");
        int id = input.askInt(" Enter the number ");
        String name = input.askStr(" Enter the name of the new Item ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println(" The Item has been replaced ");
        } else {
            System.out.println("Item replacement error.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int id = Integer.parseInt(input.askStr(" Enter the number "));
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(
                item != null ? "The Item was deleted successfully." : "Request deletion error.");
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Search for an Item by number ===");
        int id = input.askInt(" Enter the number ");
        Item item = tracker.findById(id);
        System.out.println(
                item != null ? "The Item has been found " + item : "Item " + id + " not found");
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Search for a request by name ===");
        String name = input.askStr(" Enter name ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Item " + name + " was not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Choose: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add a new Item", "Show all Items", "Edit Item",
                "Delete Item", "Show Item by number", "Show Item, by name",
                "Exit"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}