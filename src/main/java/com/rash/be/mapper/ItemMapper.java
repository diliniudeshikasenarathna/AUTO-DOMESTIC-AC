package com.rash.be.mapper;

import com.rash.be.dto.ItemDto;
import com.rash.be.entity.ItemEntity;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemEntity toEntity(ItemDto itemDto);
    ItemDto toDto(ItemEntity itemEntity);

}
