package com.example.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryapi.model.GuestModel;

@Repository
public interface GuestRepository extends JpaRepository<GuestModel, Long> {
}
