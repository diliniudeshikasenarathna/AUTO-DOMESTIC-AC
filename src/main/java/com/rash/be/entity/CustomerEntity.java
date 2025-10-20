package com.rash.be.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class CustomerEntity {
    private Long id;
    private String name;
    private String contactNumber;
    private String nic;
    private String email;
    private String address;
    private String city;
    private String remarks;
}
