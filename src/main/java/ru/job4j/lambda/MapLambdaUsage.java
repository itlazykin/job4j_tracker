package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Function<String, Integer> function = String::length;
        System.out.println("Result: " + map.computeIfAbsent("Petr", function));
        System.out.println("Result: " + map.computeIfAbsent("Petr", key -> key.length() + 10));
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        String input = "slogan of java language: write once, run everywhere".replaceAll(" ", "");
        Map<Character, Integer> mapp = new HashMap<>();
        for (char character : input.toCharArray()) {
            mapp.merge(character, 1, Integer::sum);
        }
        int max = 0;
        char result = 0;
        for (Map.Entry<Character, Integer> entry : mapp.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        System.out.println("Most used symbol: " + result);
    }
}
