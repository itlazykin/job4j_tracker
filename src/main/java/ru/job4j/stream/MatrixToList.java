package ru.job4j.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MatrixToList {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        System.out.println(matrix.stream()
                .flatMap(Collection::stream)
                        .toList());
    }

    public static List<Integer> convert(Integer[][] matrix) {
        return Arrays.stream(matrix)
                .flatMap(Arrays::stream)
                .toList();
    }
}
