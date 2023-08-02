package com.example.inventoryapi.repository.old;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.old.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
