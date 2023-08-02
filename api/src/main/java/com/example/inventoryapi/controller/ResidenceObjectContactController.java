package com.example.inventoryapi.controller;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.ResidenceObjectContactModel;
import com.example.inventoryapi.repository.ResidenceObjectContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ResidenceObjectContactController {

    @Autowired
    private ResidenceObjectContactRepository residenceObjectContactRepository;

    @GetMapping("/residenceObjectContact")
    public Page<ResidenceObjectContactModel> getResidence(Pageable pageable) {
        return residenceObjectContactRepository.findAll(pageable);
    }


    @PostMapping("/residenceObjectContact")
    public ResidenceObjectContactModel createResidence(@Valid @RequestBody ResidenceObjectContactModel residenceObjectContact) {
        return residenceObjectContactRepository.save(residenceObjectContact);
    }

    @PutMapping("/residenceObjectContact/{residenceObjectContactId}")
    public ResidenceObjectContactModel updateResidence(@PathVariable Long residenceObjectContactId,
                                   @Valid @RequestBody ResidenceObjectContactModel residenceObjectContactRequest) {
        return residenceObjectContactRepository.findById(residenceObjectContactId)
                .map(residenceObjectContact -> {
                    residenceObjectContact.setAddress(residenceObjectContactRequest.getAddress());
                    return residenceObjectContactRepository.save(residenceObjectContact);
                }).orElseThrow(() -> new ResourceNotFoundException("ResidenceObjectContact not found with id " + residenceObjectContactId));
    }


    @DeleteMapping("/residenceObjectContact/{residenceObjectContactId}")
    public ResponseEntity<?> deleteResidence(@PathVariable Long residenceObjectContactId) {
        return residenceObjectContactRepository.findById(residenceObjectContactId)
                .map(residenceObjectContact -> {
                    residenceObjectContactRepository.delete(residenceObjectContact);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ResidenceObjectContact not found with id " + residenceObjectContactId));
    }
}
