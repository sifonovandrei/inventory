package com.example.inventoryapi.model.old;

import javax.persistence.*;

import com.example.inventoryapi.model.AuditModel;

@Entity
@Table(name = "brand")
public class Brand extends AuditModel {
    @Id
    @GeneratedValue(generator = "brand_generator")
    @SequenceGenerator(
            name = "brand_generator",
            sequenceName = "brand_sequence",
            initialValue = 1
    )
    private Long id;

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
