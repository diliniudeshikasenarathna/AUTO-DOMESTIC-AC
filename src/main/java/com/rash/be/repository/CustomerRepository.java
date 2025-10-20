package com.rash.be.repository;

import com.rash.be.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
   CustomerEntity findByContactNumber(String contactNumber);
}
