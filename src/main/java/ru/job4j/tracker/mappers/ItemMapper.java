package ru.job4j.tracker.mappers;

import ru.job4j.tracker.dto.ItemDto;
import ru.job4j.tracker.model.Item;

public class ItemMapper {

    public ItemDto getDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(itemDto.getName());
        itemDto.setExpired(item.getCreated().plusYears(1L));
        return itemDto;
    }

    public Item getItemEntity(ItemDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setCreated(itemDto.getExpired().minusYears(1L));
        return item;
    }

}
