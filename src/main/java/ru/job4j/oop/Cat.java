package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.print("Kitty's name is " + this.name + ".");
        System.out.println(" " + this.name + " eat " + this.food + ".");
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        Cat black = new Cat();
        gav.giveNick("Gav");
        gav.eat("Cutlet");
        gav.show();
        black.giveNick("Black");
        black.eat("Fish");
        black.show();
    }
}
