package ru.job4j.format;

import java.util.Calendar;

public class Format {
    public static void getGreeting(String name) {
        System.out.println(String.format("Hello! I'm %s", name));
    }

    public static void getGreeting(String name, int age) {
        System.out.println(String.format("Hello! I'm %s, my age %d", name, age));
    }

    public static void getGreetingAndDateTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Hello, %s! Current date: %tF, Current time: %tT", name, instance, instance));
    }

    public static void main(String[] args) {
        getGreeting("Bob");
        getGreeting("Bob", 18);
        System.out.println(String.format("Аргумент передан? %b", 55));
        System.out.println(String.format("Jo%c4j", 'b'));
        System.out.format("Line1%nLine2");
        getGreetingAndDateTime("Den");
        System.out.println(String.format("Задаем число 0.99 - %f", 0.99));
        System.out.println(String.format("Задаем число 0.99 - %.2f", 0.99));
        System.out.println(String.format("%1$,+016.2f", 5000000.0000));
    }
}
