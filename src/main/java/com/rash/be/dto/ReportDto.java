package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReportDto {
    private String reportType;  // SALES, STOCK, PURCHASE, SERVICE
    private String description;
    private Double totalValue;
    private String dateRange;
}
