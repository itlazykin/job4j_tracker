package ru.job4j.oop;

public class TamagotchiLink {
    private int weight = 100;

    public void feed() {
        weight += 10;
    }

    public String info() {
        return "weight: " + weight;
    }

    public static void feedPet(TamagotchiLink petCopy) {
        petCopy.feed();
    }

    public static void main(String[] args) {
        TamagotchiLink pet = new TamagotchiLink();
        System.out.println("weight: " + pet.info());
        feedPet(pet);
        System.out.println("weight: " + pet.info());
    }
}

