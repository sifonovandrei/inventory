package com.example.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.ResidenceObjectModel;


@Repository
public interface ResidenceObjectRepository extends JpaRepository<ResidenceObjectModel, Long> {
}
