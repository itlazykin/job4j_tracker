package ru.job4j.oop.typeconversion;

public class Cow implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Му-му.");
    }

    public void giveMilk() {
        System.out.println(" дает человеку молоко.");
    }
}
