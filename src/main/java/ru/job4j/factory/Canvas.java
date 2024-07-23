package ru.job4j.factory;

import java.util.Scanner;

public class Canvas {
    private ShapeOperator shapeOperator;

    public Canvas(ShapeOperator shapeOperator) {
        this.shapeOperator = shapeOperator;
    }

    public void demonstrate() {
        this.shapeOperator.showInfo();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShapeOperator operator;
        System.out.print("What kind of figure do you want to build?: ");
        String ans = input.nextLine();
        if ("rectangle".equals(ans)) {
            operator = new RectangleOperator();
        }
        if ("triangle".equals(ans)) {
            operator = new TriangleOperator();
        } else {
            operator = new SquareOperator();
        }
        Canvas canvas = new Canvas(operator);
        canvas.demonstrate();
    }
}
