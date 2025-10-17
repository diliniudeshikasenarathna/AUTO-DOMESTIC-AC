package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QuotationItemDto {
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private Double unitPrice;
    private Double discount;
    private Double total;
}
