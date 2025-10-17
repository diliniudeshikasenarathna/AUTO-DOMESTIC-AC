package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InvoiceItemDto {
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private Double unitPrice;
    private Double total;
}
