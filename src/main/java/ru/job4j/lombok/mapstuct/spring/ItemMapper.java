package ru.job4j.lombok.mapstuct.spring;

import org.mapstruct.Mapper;
import ru.job4j.tracker.Item;

/*
в аннотации @Mapper указать свойство  componentModel = "spring", и маппер будет добавлен в контекст.
 */
@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item getItemFromDtoRequest(ItemDtoRequest dtoRequest);

    ItemDtoResponse getDtoResponse(Item item);
    /* тут код методов */
}
