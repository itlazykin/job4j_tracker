package ru.job4j.lombok;

public class LombokUsage {
    public static void main(String[] args) {
        var bird = new BirdData();
        bird.setAge(420);
        System.out.println(bird);
    }
}