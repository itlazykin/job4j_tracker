package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionUsage {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        System.out.println("demonstration of the .add()");
        collection.add("one");
        collection.add("2");
        collection.add("anything");
        for (String string : collection) {
            System.out.println(string);
        }
        System.out.println();
        Collection<String> array = new ArrayList<>();
        System.out.println("demonstration of the .addAll()");
        array.addAll(collection);
        for (String string : array) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println("demonstration of the .remove()");
        collection.remove("2");
        for (String string : collection) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println("demonstration of the .removeAll()");
        array.removeAll(collection);
        System.out.println("after .removeAll()");
        for (String string : collection) {
            System.out.println(string + " collection");
        }
        for (String string : array) {
            System.out.println(string + " array");
        }
        System.out.println();
        collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        array.add("two");
        System.out.println("demonstration of the .retainAll()");
        collection.retainAll(array);
        for (String string : collection) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println(".size(), .contains(), .clear(), .isEmpty(), .toArray()");
        System.out.println("Размер коллекции равен: " + collection.size());
        System.out.println("Коллекция содержит элемент two: " + collection.contains("two"));
        System.out.println("Содержимое в виде массива: " + Arrays.toString(collection.toArray()));
        collection.clear();
        System.out.println("Коллекция после очистки пуста: " + collection.isEmpty());
    }
}
