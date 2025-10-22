package com.rash.be.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    // open to any authenticated user
    @GetMapping("/items")
    public List<String> listItems() {
        return List.of("item1","item2");
    }

    // only admin can create items
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/items")
    public String createItem(@RequestBody Map<String,String> payload) {
        // create item logic...
        return "created";
    }

    // admin or user can view details (example)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/items/{id}")
    public String getItem(@PathVariable Long id) {
        return "item " + id;
    }
}
