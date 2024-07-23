package ru.job4j.factory;

public abstract class ShapeOperator {
    public void showInfo() {
        Shape shape = createShape();
        System.out.println(shape.draw());
        System.out.println("The area of the figure is equal to: " + shape.square());
    }

    public abstract Shape createShape();
}
