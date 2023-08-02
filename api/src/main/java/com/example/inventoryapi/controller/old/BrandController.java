package com.example.inventoryapi.controller.old;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.old.Brand;
import com.example.inventoryapi.repository.old.BrandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("/brands")
    public Page<Brand> getBrands(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }


    @PostMapping("/brand")
    public Brand createBrand(@Valid @RequestBody Brand brand) {
        return brandRepository.save(brand);
    }

    @PutMapping("/brand/{brandId}")
    public Brand updateBrand(@PathVariable Long brandId,
                                   @Valid @RequestBody Brand brandRequest) {
        return brandRepository.findById(brandId)
                .map(brand -> {
                    brand.setTitle(brandRequest.getTitle());
                    return brandRepository.save(brand);
                }).orElseThrow(() -> new ResourceNotFoundException("Brand not found with id " + brandId));
    }


    @DeleteMapping("/brand/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long brandId) {
        return brandRepository.findById(brandId)
                .map(brand -> {
                    brandRepository.delete(brand);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Brand not found with id " + brandId));
    }
}
