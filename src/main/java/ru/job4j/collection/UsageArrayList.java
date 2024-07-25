package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Den");
        arrayList.add("Nasty");
        arrayList.add("Lera");
        for (String string : arrayList) {
            System.out.println(string);
        }
        System.out.println();
        arrayList.remove("Lera");
        arrayList.remove(0);
        System.out.println("arrayList after .remove()");
        for (String string : arrayList) {
            System.out.println(string);
        }
        arrayList.set(0, "Tom");
        System.out.println(
                "arrayList after .set(). "
                        + "This method is rarely used because we need to know the position of the element."
                        + " They don't work with the index in business applications.");
        for (String string : arrayList) {
            System.out.println(string);
        }
    }
}
