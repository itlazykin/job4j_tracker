package ru.job4j.oop.typeconversion;

public class GuineaPig implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " громко пищит для привлечения внимания.");
    }

    public void runInWheel() {
        System.out.println(" любит побегать в колесе.");
    }
}
