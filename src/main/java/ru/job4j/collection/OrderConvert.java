package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orderList) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order key : orderList) {
            map.put(key.getNumber(), key);
        }
        return map;
    }
}
