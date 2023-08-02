package com.example.inventoryapi.model;

import javax.persistence.*;

@Entity
@Table(name = "residence_contact")
public class ResidenceContactModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "residence_contact_generator")
    @SequenceGenerator(
            name = "residence_contact_generator",
            sequenceName = "residence_contact_sequence",
            initialValue = 1
    )

    private Long id;

    @Column(columnDefinition = "text")
    private String address;
    
    @Column(columnDefinition = "text")
    private String email;

    @Column(columnDefinition = "integer")
    private Long phone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
