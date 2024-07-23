package ru.job4j.factory;

public class Square implements Shape {
    int a;

    public Square(int a) {
        this.a = a;
    }

    public String draw() {
        String ln = System.lineSeparator();
        return "*************" + ln
                + "*           *" + ln
                + "*           *" + ln
                + "*           *" + ln
                + "*           *" + ln
                + "*************";
    }

    public double square() {
        return a * a;
    }
}
