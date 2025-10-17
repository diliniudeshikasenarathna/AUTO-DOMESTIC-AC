package com.rash.be.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class SupplierDto {
    private Long id;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
    private String company;

}
