package com.example.inventoryapi.controller.old;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.old.EquipmentModel;
import com.example.inventoryapi.repository.old.EquipmentModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class EquipmentModelController {

    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    @GetMapping("/equipmentModels")
    public Page<EquipmentModel> getEquipmentModels(Pageable pageable) {
        return equipmentModelRepository.findAll(pageable);
    }


    @PostMapping("/equipmentModel")
    public EquipmentModel createEquipmentModel(@Valid @RequestBody EquipmentModel equipmentModel) {
        return equipmentModelRepository.save(equipmentModel);
    }

    @PutMapping("/equipmentModel/{equipmentModelId}")
    public EquipmentModel updateEquipmentModel(@PathVariable Long equipmentModelId,
                                   @Valid @RequestBody EquipmentModel equipmentModelRequest) {
        return equipmentModelRepository.findById(equipmentModelId)
                .map(equipmentModel -> {
                    equipmentModel.setTitle(equipmentModelRequest.getTitle());
                    return equipmentModelRepository.save(equipmentModel);
                }).orElseThrow(() -> new ResourceNotFoundException("Equipment Model not found with id " + equipmentModelId));
    }


    @DeleteMapping("/equipmentModel/{equipmentModelId}")
    public ResponseEntity<?> deleteEquipmentModel(@PathVariable Long equipmentModelId) {
        return equipmentModelRepository.findById(equipmentModelId)
                .map(equipmentModel -> {
                    equipmentModelRepository.delete(equipmentModel);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Equipment Model not found with id " + equipmentModelId));
    }
}
