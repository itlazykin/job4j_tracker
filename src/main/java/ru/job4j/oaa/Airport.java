package ru.job4j.oaa;

public class Airport {
    public static void main(String[] args) {
        Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
        System.out.println();
        airbus = new Airbus("A380");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
        airbus.setName("A400");
        System.out.println(airbus);
    }
}
