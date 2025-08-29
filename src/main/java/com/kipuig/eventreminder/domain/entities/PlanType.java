package com.kipuig.eventreminder.domain.entities;

import java.util.UUID;

public class PlanType {
    private final UUID id;
    private final String name;
    private final int maxSubscriptions;

    public PlanType(UUID id, String name, int maxSubscriptions) {
        this.id = id != null ? id : UUID.randomUUID();
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
