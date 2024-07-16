package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Врум врум по дорогам города");
    }

    @Override
    public void info() {
        System.out.println("Автобус");
    }
}
