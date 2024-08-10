package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class ListLambdaUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 7, 9, 12);
        list.forEach(System.out::println);
        UnaryOperator<Integer> operator = integer -> integer * integer;
        list.replaceAll(operator);
        System.out.println();
        list.forEach(System.out::println);
    }
}
