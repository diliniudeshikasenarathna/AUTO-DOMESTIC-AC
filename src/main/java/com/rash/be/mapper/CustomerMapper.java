package com.rash.be.mapper;

import com.rash.be.dto.CustomerDto;
import com.rash.be.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerEntity toEntity(CustomerDto customerDto);
    CustomerDto toDto(CustomerEntity customerEntity);
}
