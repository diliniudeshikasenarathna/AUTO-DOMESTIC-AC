package com.rash.be.service.impl;

import com.rash.be.dto.ItemDto;
import com.rash.be.entity.ItemEntity;
import com.rash.be.mapper.ItemMapper;
import com.rash.be.repository.ItemRepository;
import com.rash.be.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor


public class ItemServiceImpl implements ItemService {
    final ItemRepository itemRepository;
    final ItemMapper itemMapper;
    @Override
    public void addItem(ItemDto itemDto) {
        ItemEntity itemEntity=itemMapper.toEntity(itemDto);
        itemRepository.save(itemEntity);

    }

    @Override
    public List<ItemDto> getAllItem() {
        List<ItemEntity> allItem=itemRepository.findAll();
        List<ItemDto> allItemDtoList=new ArrayList<>();

        for(ItemEntity itemEntity : allItem){
            allItemDtoList.add(itemMapper.toDto(itemEntity));
        }


        return allItemDtoList;
    }

    @Override
    public ItemDto searchItemByCode(String code) {
       ItemDto itemDto=itemMapper.toDto(itemRepository.findByCode(code));
        return itemDto;
    }

    @Override
    public void deletItemByCode(String code) {
        itemRepository.deleteBycode(code);

    }

    @Override
    public List<ItemDto> searchItemsByCategory(String category) {
        List<ItemEntity> allItem=itemRepository.findByCategoryContainingIgnoreCase(category);
        List<ItemDto> allItemDtoList=new ArrayList<>();

        for(ItemEntity itemEntity : allItem){
            allItemDtoList.add(itemMapper.toDto(itemEntity));
        }


        return allItemDtoList;
    }

    @Override
    public List<ItemDto> searchItemByName(String name) {

        List<ItemEntity> allItem=itemRepository.findByNameContainingIgnoreCase(name);
        List<ItemDto> allItemDtoList=new ArrayList<>();

        for(ItemEntity itemEntity : allItem){
            allItemDtoList.add(itemMapper.toDto(itemEntity));
        }


        return allItemDtoList;
    }

    @Override
    public void updateItem(ItemDto itemDto) {
        itemRepository.save(itemMapper.toEntity(itemDto));

    }
}
