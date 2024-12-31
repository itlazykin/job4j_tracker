package ru.job4j.lombok.mapstuct.spring;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.tracker.Item;

@Service
@AllArgsConstructor
public class TrackerService {
    private final ItemRepository repository;
    private final ItemMapper itemMapper;

    public ItemDtoResponse save(ItemDtoRequest dtoRequest) {
        Item item = itemMapper.getItemFromDtoRequest(dtoRequest);
        repository.save(item);
        return itemMapper.getDtoResponse(item);
    }
}
