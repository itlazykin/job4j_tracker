package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemTest {
    @Test
    void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "B"),
                new Item(3, "C"),
                new Item(1, "A")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "C"),
                new Item(2, "B"),
                new Item(1, "A")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "B"),
                new Item(3, "C"),
                new Item(1, "A")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "A"),
                new Item(2, "B"),
                new Item(3, "C")
        );
        assertThat(items).isEqualTo(expected);
    }
}