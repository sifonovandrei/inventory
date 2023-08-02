package com.example.inventoryapi.model;

import javax.persistence.*;

@Entity
@Table(name = "guest")
public class GuestModel extends AuditModel {
    @Id
    @GeneratedValue(generator = "guest_generator")
    @SequenceGenerator(
            name = "guest_generator",
            sequenceName = "guest_sequence",
            initialValue = 1
    )

    private Long id;

    @Column(columnDefinition = "integer")
    private Long nationality_id;
    
    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "text")
    private String last_name;

    @Column(columnDefinition = "integer")
    private Long phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
