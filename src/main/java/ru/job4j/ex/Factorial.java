package ru.job4j.ex;

public class Factorial {
    public static int calc(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number could not be less than 0");
        }
        int result = 1;
        for (int index = 2; index <= number; index++) {
            result *= index;
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        calc(10);
    }
}