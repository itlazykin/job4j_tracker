package ru.job4j.escape;

public class EscapeExample {
    public static void main(String[] args) {
        String string = "Я изучаю на \"Job4j\" экранирование символов";
        System.out.println(string);
        System.out.println();
        char escape = '\"';
        System.out.println(escape);
        System.out.println();
        String string1 = "Я изучаю на 'Job4j' экранирование символов";
        System.out.println(string1);
        System.out.println();
        String string2 = "C:\\projects\\job4j\\File.java";
        System.out.println(string2);
        System.out.println();
        System.out.print("Старый длинный текст\r");
        System.out.println("Новый текст");
        System.out.println();
        System.out.print("Первая строка\nВторая строка");
        System.out.println();
        System.out.println();
        System.out.println("Без отступа");
        System.out.println("\tОдин отступ");
        System.out.println("\t\tДва отступа");
        System.out.println();
        System.out.println("Job4jjj\b\b");
    }
}
