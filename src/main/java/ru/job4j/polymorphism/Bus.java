package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Врум врум");
    }

    @Override
    public void passengers(int number) {
        System.out.println("В автобусе сейчас " + number + " пассажиров");
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 100;
    }
}
