package com.rash.be.repository;

import com.rash.be.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
   ItemEntity findByCode(String code);
    void deleteBycode(String code);
    List<ItemEntity> findByNameContainingIgnoreCase(String name);
    List<ItemEntity> findByCategoryContainingIgnoreCase(String category);
}
