package com.rash.be.service;

import com.rash.be.dto.ItemDto;

import java.util.List;

public interface ItemService {
    void addItem(ItemDto itemDto);
    List<ItemDto> getAllItem();

    ItemDto searchItemByCode(String code);

    void deletItemByCode(String code);

    List<ItemDto> searchItemsByCategory(String category);

    List<ItemDto> searchItemByName(String name);

    void updateItem(ItemDto item);

}
