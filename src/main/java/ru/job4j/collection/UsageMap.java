package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dzaka89@gmail.com", "Denis Lazykin");
        map.put("dzaka89@gmail.ru", "Denis Lazykin");
        map.put("dzaka89@gmail.com", "Denis Andreevich Lazykin");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
