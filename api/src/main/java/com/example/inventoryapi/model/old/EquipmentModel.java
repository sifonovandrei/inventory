package com.example.inventoryapi.model.old;

import javax.persistence.*;

import com.example.inventoryapi.model.AuditModel;

@Entity
@Table(name = "equipment_model")
public class EquipmentModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "equipment_model_generator")
    @SequenceGenerator(
            name = "equipment_model_generator",
            sequenceName = "equipment_model_sequence",
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
