package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameTest {
    @Test
    void whenFindByNameThanOk() {
        var output = new StubOutput();
        var tracker = new MemTracker();
        var item = new Item("item");
        tracker.add(item);
        var findByName = new FindByName(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item + ln
        );
    }

    @Test
    void whenFindByNameThanFail() {
        var output = new StubOutput();
        var tracker = new MemTracker();
        var item = new Item("item");
        tracker.add(item);
        var findByName = new FindByName(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("name");
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: name не найдены." + ln
        );
    }
}