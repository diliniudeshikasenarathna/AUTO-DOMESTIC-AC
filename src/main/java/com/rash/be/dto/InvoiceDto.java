package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class InvoiceDto {
    private Long id;
    private String invoiceNumber;
    private Long customerId;
    private String customerName;
    private LocalDate date;
    private Double totalAmount;
    private Double paidAmount;
    private String paymentStatus; // PAID, PENDING, PARTIAL
    private String remarks;

    private List<InvoiceItemDto> items;
}
