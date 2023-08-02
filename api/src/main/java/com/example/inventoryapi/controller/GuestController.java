package com.example.inventoryapi.controller;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.GuestModel;
import com.example.inventoryapi.repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/guest")
    public Page<GuestModel> getInventory(Pageable pageable) {
        return guestRepository.findAll(pageable);
    }


    @PostMapping("/guest")
    public GuestModel createInventory(@Valid @RequestBody GuestModel guest) {
        return guestRepository.save(guest);
    }

    @PutMapping("/guest/{guestId}")
    public GuestModel updateInventory(@PathVariable Long guestId,
                                   @Valid @RequestBody GuestModel guestRequest) {
        return guestRepository.findById(guestId)
                .map(guest -> {
                    guest.setName(guestRequest.getName());
                    guest.setLastName(guestRequest.getLastName());
                    guest.setPhone(guestRequest.getPhone());
                    return guestRepository.save(guest);
                }).orElseThrow(() -> new ResourceNotFoundException("Guest not found with id " + guestId));
    }


    @DeleteMapping("/guest/{guestId}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long guestId) {
        return guestRepository.findById(guestId)
                .map(guest -> {
                    guestRepository.delete(guest);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Guest not found with id " + guestId));
    }
}
