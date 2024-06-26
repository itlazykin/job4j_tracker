package ru.job4j.oop;

public class Story {
    public static void main(String[] args) {
        Girl lera = new Girl();
        Pioneer petya = new Pioneer();
        Wolf wolf = new Wolf();
        petya.kill(wolf);
        wolf.eat(lera);
        lera.help(petya);
    }
}
