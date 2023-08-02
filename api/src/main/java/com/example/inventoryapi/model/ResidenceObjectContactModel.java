package com.example.inventoryapi.model;

import javax.persistence.*;

@Entity
@Table(name = "residence_object_contact")
public class ResidenceObjectContactModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "residence_object_contact_generator")
    @SequenceGenerator(
            name = "residence_object_contact_generator",
            sequenceName = "residence_object_contact_sequence",
            initialValue = 1
    )

    private Long id;

    @Column(columnDefinition = "text")
    private String address;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
