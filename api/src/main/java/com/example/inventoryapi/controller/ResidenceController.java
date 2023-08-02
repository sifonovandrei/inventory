package com.example.inventoryapi.controller;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.ResidenceModel;
import com.example.inventoryapi.repository.ResidenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ResidenceController {

    @Autowired
    private ResidenceRepository residenceRepository;

    @GetMapping("/residence")
    public Page<ResidenceModel> getResidence(Pageable pageable) {
        return residenceRepository.findAll(pageable);
    }

    @GetMapping("/residenceWithContact")
    @Query("select * from residence r inner join residence_contact rc on rc.residence_id = r.id")
    public Page<ResidenceModel> getResidenceWithContact(Pageable pageable) {
        return residenceRepository.findAll(pageable);
    }

    @PostMapping("/residence")
    public ResidenceModel createResidence(@Valid @RequestBody ResidenceModel residence) {
        return residenceRepository.save(residence);
    }

    @PutMapping("/residence/{residenceId}")
    public ResidenceModel updateResidence(@PathVariable Long residenceId,
            @Valid @RequestBody ResidenceModel residenceRequest) {
        return residenceRepository.findById(residenceId)
                .map(residence -> {
                    residence.setTitle(residenceRequest.getTitle());
                    return residenceRepository.save(residence);
                }).orElseThrow(() -> new ResourceNotFoundException("Residence not found with id " + residenceId));
    }

    @DeleteMapping("/residence/{residenceId}")
    public ResponseEntity<?> deleteResidence(@PathVariable Long residenceId) {
        return residenceRepository.findById(residenceId)
                .map(residence -> {
                    residenceRepository.delete(residence);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Residence not found with id " + residenceId));
    }
}
