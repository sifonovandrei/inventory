package com.example.inventoryapi.repository.old;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.old.EquipmentModel;

@Repository
public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, Long> {
}
