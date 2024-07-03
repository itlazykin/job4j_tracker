package ru.job4j.inheritance;

public class Programmer extends Profession {
    private final String programLanguage;

    public Programmer(boolean degree, String programLanguage) {
        super(degree);
        this.programLanguage = programLanguage;
    }
}
