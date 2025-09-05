package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "PlanTypes")
public class PlanTypeEntity {
    
    @Id
    private UUID id;
    
    private String name;
    private int maxSubscriptions;
    
    public PlanTypeEntity() {
    }

    public PlanTypeEntity(UUID id, String name, int maxSubscriptions) {
        this.id = id;
        this.name = name;
        this.maxSubscriptions = maxSubscriptions;
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getMaxSubscriptions() {
        return maxSubscriptions;
    }
    
    public void setMaxSubscriptions(int maxSubscriptions) {
        this.maxSubscriptions = maxSubscriptions;
    }
}