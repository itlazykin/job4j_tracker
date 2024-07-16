package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("летаю в небе, попадая в птиц.");
    }

    @Override
    public void info() {
        System.out.println("Самолет");
    }
}
