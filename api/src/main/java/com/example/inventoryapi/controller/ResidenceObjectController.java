package com.example.inventoryapi.controller;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.ResidenceObjectModel;
import com.example.inventoryapi.repository.ResidenceObjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ResidenceObjectController {

    @Autowired
    private ResidenceObjectRepository residenceObjectRepository;

    @GetMapping("/residenceObject")
    public Page<ResidenceObjectModel> getResidence(Pageable pageable) {
        return residenceObjectRepository.findAll(pageable);
    }


    @PostMapping("/residenceObject")
    public ResidenceObjectModel createResidence(@Valid @RequestBody ResidenceObjectModel residenceObject) {
        return residenceObjectRepository.save(residenceObject);
    }

    @PutMapping("/residenceObject/{residenceObjectId}")
    public ResidenceObjectModel updateResidence(@PathVariable Long residenceObjectId,
                                   @Valid @RequestBody ResidenceObjectModel residenceObjectRequest) {
        return residenceObjectRepository.findById(residenceObjectId)
                .map(residenceObject -> {
                    residenceObject.setResidenceId(residenceObjectRequest.getResidenceId());
                    residenceObject.setTitle(residenceObjectRequest.getTitle());
                    return residenceObjectRepository.save(residenceObject);
                }).orElseThrow(() -> new ResourceNotFoundException("ResidenceObject not found with id " + residenceObjectId));
    }


    @DeleteMapping("/residenceObject/{residenceObjectId}")
    public ResponseEntity<?> deleteResidence(@PathVariable Long residenceObjectId) {
        return residenceObjectRepository.findById(residenceObjectId)
                .map(residenceObject -> {
                    residenceObjectRepository.delete(residenceObject);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ResidenceObject not found with id " + residenceObjectId));
    }
}
