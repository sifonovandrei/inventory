package com.example.inventoryapi.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "category_generator")
    @SequenceGenerator(
            name = "category_generator",
            sequenceName = "category_sequence",
            initialValue = 1
    )

    private Long id;

    @Column(columnDefinition = "integer")
    private Long parent_id;
    
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
