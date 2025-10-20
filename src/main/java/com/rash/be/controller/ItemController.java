package com.rash.be.controller;

import com.rash.be.dto.ItemDto;
import com.rash.be.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {
    final ItemService itemService;

    @PostMapping("/add-item")
    public void addItem(@RequestBody ItemDto itemDto){
        itemService.addItem(itemDto);
    }
    @GetMapping("/get-all")
    public List<ItemDto> getAllItems(){
        return itemService.getAllItem();
    }

    @PutMapping("/update-item")
    public void updateItem(@RequestBody ItemDto itemDto){
        itemService.updateItem(itemDto);
    }

    @DeleteMapping("/delete-item")
    public void deleteItem(@RequestParam String itemCode){
        itemService.deletItemByCode(itemCode);
    }

    @GetMapping("/search-by-code")
    public ItemDto searchByCode(@RequestParam String code){
      return itemService.searchItemByCode(code);
    }

    @GetMapping("/search-item-by-name")
    public List<ItemDto> searchItemByName(@RequestParam String name){
       return itemService.searchItemByName(name);
    }
    @GetMapping("/search-item-by-category")
    public List<ItemDto> searchItemByCategory(@RequestParam String category){
        return itemService.searchItemsByCategory(category);
    }

}
