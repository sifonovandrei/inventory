package com.example.inventoryapi.model;

import javax.persistence.*;

@Entity
@Table(name = "nationality")
public class NationalityModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "nationality_generator")
    @SequenceGenerator(
            name = "nationality_generator",
            sequenceName = "nationality_sequence",
            initialValue = 1
    )

    private Long id;
    
    @Column(columnDefinition = "text")
    private String title;

     @Column(columnDefinition = "text")
    private String abbreviation;

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

     public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
