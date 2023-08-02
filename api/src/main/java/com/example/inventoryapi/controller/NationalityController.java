package com.example.inventoryapi.controller;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.NationalityModel;
import com.example.inventoryapi.repository.NationalityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class NationalityController {

    @Autowired
    private NationalityRepository nationalityRepository;

    @GetMapping("/nationality")
    public Page<NationalityModel> getInventory(Pageable pageable) {
        return nationalityRepository.findAll(pageable);
    }


    @PostMapping("/nationality")
    public NationalityModel createInventory(@Valid @RequestBody NationalityModel nationality) {
        return nationalityRepository.save(nationality);
    }

    @PutMapping("/nationality/{nationalityId}")
    public NationalityModel updateInventory(@PathVariable Long nationalityId,
                                   @Valid @RequestBody NationalityModel inventoryRequest) {
        return nationalityRepository.findById(nationalityId)
                .map(nationality -> {
                    nationality.setTitle(inventoryRequest.getTitle());
                    nationality.setAbbreviation(inventoryRequest.getAbbreviation());
                    return nationalityRepository.save(nationality);
                }).orElseThrow(() -> new ResourceNotFoundException("Nationality not found with id " + nationalityId));
    }


    @DeleteMapping("/nationality/{nationalityId}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long nationalityId) {
        return nationalityRepository.findById(nationalityId)
                .map(nationality -> {
                    nationalityRepository.delete(nationality);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Nationality not found with id " + nationalityId));
    }
}
