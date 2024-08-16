package ru.job4j.api;

import java.util.stream.Stream;

public class DropWile {
    public static void main(String[] args) {
        System.out.println("Stream.dropWhile - пропускает все элементы потока, пока они удовлетворяют условию. "
                + "При обработке первого элемента, который не удовлетворяет условию,  "
                + "этот и все остальные элементы независимо от условия будут проходить дальше.");
        Stream.of(1, 2, 3, 4, 1, 2)
                .dropWhile(v -> v < 3)
                .map(v -> "Result " + v)
                .forEach(System.out::println);
    }
}
