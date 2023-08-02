package com.example.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.ResidenceModel;

@Repository
public interface ResidenceRepository extends JpaRepository<ResidenceModel, Long> {
}
