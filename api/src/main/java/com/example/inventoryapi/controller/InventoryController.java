package com.example.inventoryapi.controller;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.InventoryModel;
import com.example.inventoryapi.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/inventory")
    public Page<InventoryModel> getInventory(Pageable pageable) {
        return inventoryRepository.findAll(pageable);
    }


    @PostMapping("/inventory")
    public InventoryModel createInventory(@Valid @RequestBody InventoryModel inventory) {
        return inventoryRepository.save(inventory);
    }

    @PutMapping("/inventory/{inventoryId}")
    public InventoryModel updateInventory(@PathVariable Long inventoryId,
                                   @Valid @RequestBody InventoryModel inventoryRequest) {
        return inventoryRepository.findById(inventoryId)
                .map(inventory -> {
                    inventory.setTitle(inventoryRequest.getTitle());
                    return inventoryRepository.save(inventory);
                }).orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id " + inventoryId));
    }


    @DeleteMapping("/inventory/{inventoryId}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .map(inventory -> {
                    inventoryRepository.delete(inventory);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id " + inventoryId));
    }
}
