package ru.job4j.oop;

public class Calculator {
    private final static int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public static int minus(int a) {
        return a - X;
    }

    public int multiply(int a) {
        return X * a;
    }

    public int divide(int a) {
        return a / X;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static class Multiple {

        private final int result;

        public Multiple(int number) {
            result = number;
        }

        public int getResult() {
            return result;
        }
    }

    public static Multiple getMultiple(int value) {
        int result = value * value;
        return new Multiple(result);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(10));
        System.out.println(calculator.multiply(10));
        System.out.println(calculator.sumAllOperation(10));
        System.out.println(sum(5));
        System.out.println(minus(2));
        Calculator.Multiple multiple = Calculator.getMultiple(3);
        System.out.println("Квадрат числа равен " + multiple.getResult());
    }
}
