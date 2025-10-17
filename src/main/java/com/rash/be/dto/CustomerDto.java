package com.rash.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString

public class CustomerDto {
    private Long id;
    private String name;
    private String contactNumber;
    private String nic;
    private String email;
    private String address;
    private String city;
    private String remarks;
}
