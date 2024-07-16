package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Чух чух чух по рельсам");
    }

    @Override
    public void info() {
        System.out.println("Поезд");
    }
}
