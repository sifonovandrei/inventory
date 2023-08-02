package com.example.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.ResidenceContactModel;

@Repository
public interface ResidenceContactRepository extends JpaRepository<ResidenceContactModel, Long> {

}
