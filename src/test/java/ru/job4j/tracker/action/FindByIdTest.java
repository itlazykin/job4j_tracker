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

class FindByIdTest {
    @Test
    void whenFindByIdThanOk() {
        var output = new StubOutput();
        var tracker = new MemTracker();
        var item = new Item("item");
        tracker.add(item);
        var findById = new FindById(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + "Заявка изменена успешно." + ln
        );
    }

    @Test
    void whenFindByIdThanFail() {
        var output = new StubOutput();
        var tracker = new MemTracker();
        var item = new Item("item");
        tracker.add(item);
        var findById = new FindById(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(13);
        findById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + "Заявка с введенным id: 13 не найдена." + ln
        );
    }
}