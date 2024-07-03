package ru.job4j.pojo;

public class Library {
    public static void print(Book[] library) {
        for (Book books : library) {
            System.out.println(books.getName() + " - " + books.getPage());
        }
        System.out.println();
    }

    public static void print(Book[] library, String name) {
        for (Book books : library) {
            if (books.getName().equals(name)) {
                System.out.println(books.getName() + " - " + books.getPage());
            }
            System.out.println();
        }
    }

    public static void swap(Book[] library, int source, int destination) {
        Book book = library[source];
        library[source] = library[destination];
        library[destination] = book;
    }

    public static void main(String[] args) {
        Book harryPotter = new Book("Harry Potter", 514);
        Book shantaram = new Book("Shantaram", 1483);
        Book markes = new Book("100 years of loneliness ", 795);
        Book clean = new Book("Clean code", 2654);
        Book[] books = {harryPotter, shantaram, markes, clean};
        print(books);
        swap(books, 0, 3);
        print(books);
        print(books, "Clean code");
    }
}
