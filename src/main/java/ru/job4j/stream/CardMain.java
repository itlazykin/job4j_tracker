package ru.job4j.stream;

import java.util.stream.Stream;

public class CardMain {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(Stream::ofNullable)
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}
