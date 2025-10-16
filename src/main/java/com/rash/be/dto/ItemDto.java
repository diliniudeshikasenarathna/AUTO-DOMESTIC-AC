package com.rash.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String itemCode;
    private String name;
    private String description;
    private String qty;
    private String cost;
    private String discount;

}
