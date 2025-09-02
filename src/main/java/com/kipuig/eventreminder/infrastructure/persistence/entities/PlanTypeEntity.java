package com.kipuig.eventreminder.infrastructure.persistence.entities;

import java.util.UUID;

public class PlanTypeEntity {
    
    private final UUID id;
    private final String name;
    private final int maxSubscriptions;

    public PlanTypeEntity(UUID id, String name, int maxSubscriptions) {
        this.id = id;
        this.name = name;
        this.maxSubscriptions = maxSubscriptions;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxSubscriptions() {
        return maxSubscriptions;
    }
}
