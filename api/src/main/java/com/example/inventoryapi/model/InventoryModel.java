package com.example.inventoryapi.model;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class InventoryModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "inventory_generator")
    @SequenceGenerator(
            name = "inventory_generator",
            sequenceName = "inventory_sequence",
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
