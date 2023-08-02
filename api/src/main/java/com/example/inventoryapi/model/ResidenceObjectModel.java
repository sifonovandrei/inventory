package com.example.inventoryapi.model;

import javax.persistence.*;

@Entity
@Table(name = "residence_object")
public class ResidenceObjectModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "residence_object_generator")
    @SequenceGenerator(
            name = "residence_object_generator",
            sequenceName = "residence_object_sequence",
            initialValue = 1
    )

    private Long id;

    @Column(name = "residence_id", columnDefinition = "integer")
    private Long residenceId;

    @Column(name = "residence_object_contact_id", columnDefinition = "integer")
    private Long residenceObjectContactId;
    
    @Column(columnDefinition = "text")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }
}
