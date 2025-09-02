package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private UUID id;
    private String email;
    private UUID planTypeId;

    protected UserEntity() {
    }

    public UserEntity(UUID id, String email, UUID planTypeId) {
        this.id = id;
        this.email = email;
        this.planTypeId = planTypeId;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public UUID getPlanTypeId() {
        return planTypeId;
    }
}
