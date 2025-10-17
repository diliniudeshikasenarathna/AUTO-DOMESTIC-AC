package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class PurchaseDto {
    private Long id;
    private String purchaseNumber;
    private Long supplierId;
    private String supplierName;
    private LocalDate date;
    private Double totalAmount;

    private List<PurchaseItemDto> items;
}
