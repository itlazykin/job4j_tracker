package ru.job4j.factory;

public class Rectangle implements Shape {
    int a;
    int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String draw() {
        String ln = System.lineSeparator();
        return "******" + ln
                + "*    *" + ln
                + "*    *" + ln
                + "******";
    }

    public double square() {
        return a * b;
    }
}
