package com.rash.be.service;

import com.rash.be.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDto customerDto);
    CustomerDto searchCustomerByContanct(String contactNumber);
    List<CustomerDto> getAll();

    void deleteCustomer(CustomerDto customerDto);
    void updateCustomer(CustomerDto customerDto);

}
