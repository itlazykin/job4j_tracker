package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends Pizza {
    private static final String TOMATO_CHEESE = "extra cheese + tomato";

    @Override
    public String name() {
        return super.name() + " + " + TOMATO_CHEESE;
    }
}
