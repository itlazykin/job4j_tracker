package ru.job4j.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status kia = Status.FINISHED;
        Status bmw = Status.IN_WORK;
        System.out.println("Статус kia: " + kia.getInfo());
        System.out.println("Статус bmw: " + bmw.getInfo());
        System.out.println("Статус kia: " + kia.getMessage());
        System.out.println("Статус bmw: " + bmw.getMessage());
    }
}
