package ru.job4j.api;

import java.util.List;

public class TakeWile {
    public static void main(String[] args) {
        System.out.println("takeWhile() - метод позволяет получать поток данных до тех пор, пока условие истина.");
        List.of(1, 2, 3, 4).stream()
                .takeWhile(v -> v < 3)
                .map(v -> "Result " + v)
                .forEach(System.out::println);
    }
}
