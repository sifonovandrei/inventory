package com.example.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.InventoryModel;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryModel, Long> {

}
