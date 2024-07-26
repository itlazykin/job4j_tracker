package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Mercedes");
        autos.add("Hyundai");
        autos.add("Volvo");
        autos.add("Hyundai");
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
