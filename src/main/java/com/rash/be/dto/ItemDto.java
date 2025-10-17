package com.rash.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString

public class ItemDto {
    private Long id;
    private String name;
    private String sku;
    private String description;
    private Double price;
    private Double cost;
    private Integer quantity;
    private String unit;
    private String supplier;
    private Integer lowStockThreshold;
}
