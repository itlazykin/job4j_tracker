package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка исправлена: " + active);
        System.out.println("Номер ошибки " + status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 1, "Ошибка 404");
        Error error2 = new Error(false, 0, "Все ОК");
        Error error3 = new Error(true, 2, "Ошибка 420");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
