package com.example.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.ResidenceObjectContactModel;

@Repository
public interface ResidenceObjectContactRepository extends JpaRepository<ResidenceObjectContactModel, Long> {
}
