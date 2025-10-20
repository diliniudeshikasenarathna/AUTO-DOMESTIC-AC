package com.rash.be.controller;

import com.rash.be.dto.CustomerDto;
import com.rash.be.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    final CustomerService customerService;

    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody CustomerDto customerDto){
        customerService.addCustomer(customerDto);
    }

    @GetMapping("/get-all")
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAll();
    }
    @GetMapping("/get-customer-by-contanct")
    public CustomerDto getCustomerByContact(@RequestParam String contactNo){
        return customerService.searchCustomerByContanct(contactNo);
    }

    @DeleteMapping("/delete-customer")
    public void deleteCustomer(@RequestBody CustomerDto customerDto){
        customerService.deleteCustomer(customerDto);
    }

    @PatchMapping("/update-customer")
    public void updateCustomer(@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerDto);
    }




}
