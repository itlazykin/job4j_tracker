package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteTest {
    @Test
    void whenDeleteOk() {
        var output = new StubOutput();
        var tracker = new MemTracker();
        tracker.add(new Item("Delete item"));
        var delete = new Delete(output);
        var input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @Test
    void whenDeleteThanFalse() {
        var output = new StubOutput();
        var tracker = new MemTracker();
        tracker.add(new Item("Delete item"));
        var delete = new Delete(output);
        var input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(13);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + ln
                        + "Ошибка удаления заявки." + ln
        );
    }
}