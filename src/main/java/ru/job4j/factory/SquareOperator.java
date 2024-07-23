package ru.job4j.factory;

import java.util.Scanner;

public class SquareOperator extends ShapeOperator {
    private Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.print("Enter the side of the square: ");
        int a = Integer.parseInt(input.nextLine());
        return new Square(a);
    }
}
