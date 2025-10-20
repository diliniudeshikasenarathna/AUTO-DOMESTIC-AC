package com.rash.be.service;

import com.rash.be.dto.CustomerDto;

public interface CustomerService {
    void addCustomer(CustomerDto customerDto);
    CustomerDto searchCustomerByContanct(String contactNumber);
}
