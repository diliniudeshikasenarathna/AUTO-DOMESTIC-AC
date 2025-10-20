package com.rash.be.service.impl;

import com.rash.be.dto.CustomerDto;
import com.rash.be.entity.CustomerEntity;
import com.rash.be.mapper.CustomerMapper;
import com.rash.be.repository.CustomerRepository;
import com.rash.be.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository customerRepository;
    final CustomerMapper customerMapper;
    @Override
    public void addCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity=customerMapper.toEntity(customerDto);
        customerRepository.save(customerEntity);
    }

    @Override
    public CustomerDto searchCustomerByContanct(String contactNumber) {
       CustomerDto customerDto=customerMapper.toDto(customerRepository.findByContactNumber(contactNumber));
       return customerDto;
    }

    @Override
    public List<CustomerDto> getAll() {
        List<CustomerEntity> allCustomerList=customerRepository.findAll();
        List <CustomerDto> allCustomerDtosList=new ArrayList<>();

        for(CustomerEntity customerEntity: allCustomerList){
            allCustomerDtosList.add(customerMapper.toDto(customerEntity));
        }
        return allCustomerDtosList;
    }

    @Override
    public void deleteCustomer(CustomerDto customerDto) {
        customerRepository.delete(customerMapper.toEntity(customerDto));
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        customerRepository.save(customerMapper.toEntity(customerDto));

    }
}
