package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Transport transport = car;
        Object object = car;
        Object objectCar = new Car();
        Car carFromObj = (Car) objectCar;
        Object bicycle = new Bicycle();
        System.out.println(new Bicycle());
        System.out.println(new Object());
        System.out.println(new Car());
        System.out.println(new Transport());
    }
}
