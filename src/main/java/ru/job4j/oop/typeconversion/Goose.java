package ru.job4j.oop.typeconversion;

public class Goose implements Animal {
    public void bringFeather() {
        System.out.println(" приносит перо для подушек.");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Га-га");
    }
}
