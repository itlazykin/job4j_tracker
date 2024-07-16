package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Creating a new application ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("The added application: " + item);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Withdrawal of all applications ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("The repository does not contain applications yet");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Change application ===");
        int id = input.askInt(" Enter the number ");
        String name = input.askStr(" Enter the name of the new application ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println(" The application has been replaced ");
        } else {
            System.out.println("Application replacement error.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete application ===");
        int id = Integer.parseInt(input.askStr(" Enter the number "));
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(
                item != null ? "The application was deleted successfully." : "Request deletion error.");
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Search for an application by number ===");
        int id = input.askInt(" Enter the number ");
        Item item = tracker.findById(id);
        System.out.println(
                item != null ? "The application has been found " + item : "Application " + id + " not found");
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
            System.out.println("Application " + name + " was not found");
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
                "Add a new application", "Show all applications", "Edit application",
                "Delete application", "Show application by number", "Show applications by name",
                "End the program"
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