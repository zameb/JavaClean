package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private UUID id;
    private String email;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_type_id", referencedColumnName = "id")
    private PlanTypeEntity planType;

    protected UserEntity() {
    }

    public UserEntity(UUID id, String email, PlanTypeEntity planType) {
        this.id = id;
        this.email = email;
        this.planType = planType;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public PlanTypeEntity getPlanType() {
        return planType;
    }
}
