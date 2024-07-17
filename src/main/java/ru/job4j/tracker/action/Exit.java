package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class Exit implements UserAction {
    private final Output output;

    public Exit(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("Goodbye");
        return false;
    }
}
