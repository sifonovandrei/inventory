package com.example.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.NationalityModel;

@Repository
public interface NationalityRepository extends JpaRepository<NationalityModel, Long> {
}
