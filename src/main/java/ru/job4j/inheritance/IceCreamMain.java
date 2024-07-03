package ru.job4j.inheritance;

public class IceCreamMain {
    public static void main(String[] args) {
        IceCreamPlusJamPlusNuts iceCreamPlusJamPlusNuts = new IceCreamPlusJamPlusNuts(4);
        System.out.println(iceCreamPlusJamPlusNuts.price());
        IceCreamPlusJam iceCreamPlusJam = new IceCreamPlusJam(4);
        System.out.println(iceCreamPlusJam.price());
    }
}
