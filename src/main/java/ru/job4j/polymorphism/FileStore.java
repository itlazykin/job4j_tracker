package ru.job4j.polymorphism;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileStore implements Store {
    private final Path filePath;

    public FileStore() {
        this.filePath = null;
    }

    public void save(String data) {
        try {
            assert filePath != null;
            Files.writeString(filePath, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    public String read() {
        try {
            assert filePath != null;
            return Files.readString(filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении данных: " + e.getMessage());
        }
        return null;
    }
}