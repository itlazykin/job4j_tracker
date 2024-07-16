package ru.job4j.oop.typeconversion;

public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Гав-гав.");
    }

    public void runAfterCat() {
        System.out.println(" не любит кошек, постоянно за ними гоняется.");
    }
}