package com.example.inventoryapi.controller;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.ResidenceContactModel;
import com.example.inventoryapi.repository.ResidenceContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ResidenceContactController {

    @Autowired
    private ResidenceContactRepository residenceContactRepository;

    @GetMapping("/residenceContact")
    public Page<ResidenceContactModel> getResidence(Pageable pageable) {
        return residenceContactRepository.findAll(pageable);
    }


    @PostMapping("/residenceContact")
    public ResidenceContactModel createResidence(@Valid @RequestBody ResidenceContactModel residence) {
        return residenceContactRepository.save(residence);
    }

    @PutMapping("/residenceContact/{residenceContactId}")
    public ResidenceContactModel updateResidence(@PathVariable Long residenceContactId,
                                   @Valid @RequestBody ResidenceContactModel residenceContactRequest) {
        return residenceContactRepository.findById(residenceContactId)
                .map(residenceContact -> {
                    residenceContact.setAddress(residenceContactRequest.getAddress());
                    residenceContact.setPhone(residenceContactRequest.getPhone());
                    residenceContact.setEmail(residenceContactRequest.getEmail());
                    return residenceContactRepository.save(residenceContact);
                }).orElseThrow(() -> new ResourceNotFoundException("ResidenceContact not found with id " + residenceContactId));
    }


    @DeleteMapping("/residenceContact/{residenceContactId}")
    public ResponseEntity<?> deleteResidence(@PathVariable Long residenceContactId) {
        return residenceContactRepository.findById(residenceContactId)
                .map(residenceContact -> {
                    residenceContactRepository.delete(residenceContact);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ResidenceContact not found with id " + residenceContactId));
    }
}
