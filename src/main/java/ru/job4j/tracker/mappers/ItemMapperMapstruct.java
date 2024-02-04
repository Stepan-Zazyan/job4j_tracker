package ru.job4j.tracker.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.tracker.dto.ItemDto;
import ru.job4j.tracker.model.Item;

@Mapper
public interface ItemMapperMapstruct {
    @Mapping(target = "expired", source = "created")
    ItemDto getModelFromEntity(Item item);

    @Mapping(target = "created", source = "expired")
    Item getEntityFromDto(ItemDto itemDto);
}
