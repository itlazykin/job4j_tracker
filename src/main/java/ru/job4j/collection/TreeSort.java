package ru.job4j.collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSort {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        System.out.println(numbers);
        Set<Integer> n = new TreeSet<>(Collections.reverseOrder());
        n.add(5);
        n.add(1);
        n.add(3);
        System.out.println(n);
    }
}
