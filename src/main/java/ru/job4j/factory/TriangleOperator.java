package ru.job4j.factory;

import java.util.Scanner;

public class TriangleOperator extends ShapeOperator {
    private Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.print("Enter the length of the base of the triangle: ");
        int a = Integer.parseInt(input.nextLine());
        System.out.print("Enter the height of the triangle: ");
        int b = Integer.parseInt(input.nextLine());
        return new Triangle(a, b);
    }
}
