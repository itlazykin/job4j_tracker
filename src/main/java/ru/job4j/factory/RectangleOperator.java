package ru.job4j.factory;

import java.util.Scanner;

public class RectangleOperator extends ShapeOperator {
    private Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.print("Enter the width of the rectangle: ");
        int a = Integer.parseInt(input.nextLine());
        System.out.print("Enter the length of the rectangle: ");
        int b = Integer.parseInt(input.nextLine());
        return new Rectangle(a, b);
    }
}
