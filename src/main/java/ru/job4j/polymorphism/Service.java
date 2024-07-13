package ru.job4j.polymorphism;

public class Service {
    private Store store;

    public Service(Store store) {
        this.store = store;
    }

    public void add() {
        store.save("Den Lazykin");
    }

    public static void main(String[] args) {
        FileStore store = new FileStore();
        Service service = new Service(store);
        service.add();
    }
}