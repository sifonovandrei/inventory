package com.example.inventoryapi.model;

import javax.persistence.*;

@Entity
@Table(name = "residence")
public class ResidenceModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "residence_generator")
    @SequenceGenerator(
            name = "residence_generator",
            sequenceName = "residence_sequence",
            initialValue = 1
    )

    private Long id;

    @Column(columnDefinition = "integer")
    private Long residence_contact_id;
    
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
}
