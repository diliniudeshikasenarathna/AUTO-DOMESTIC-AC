package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseItemDto {
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private Double costPrice;
    private Double total;
}
