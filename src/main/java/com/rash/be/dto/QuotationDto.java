package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@Data
@ToString
public class QuotationDto {
    private Long id;
    private Long customerId;
    private String customerName;
    private String customerContanctNo;
    private String quotationNumber;
    private LocalDate date;
    private Double totalAmount;
    private String status; // DRAFT, SENT, CONVERTED

    private List<QuotationItemDto> items;
}
