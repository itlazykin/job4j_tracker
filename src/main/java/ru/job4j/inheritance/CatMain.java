package ru.job4j.inheritance;

public class CatMain {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.canPurr());
        ToyCat toyCat = new ToyCat();
        System.out.println(toyCat.canPurr());
        System.out.println(toyCat.canBeWashByWashMachine());
    }
}
