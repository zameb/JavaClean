package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import java.util.UUID;

public class PlanType {

    private final UUID id;
    private final String name;
    private final int maxSubscriptions;

    public PlanType(UUID id, String name, int maxSubscriptions) throws InvalidInitializationException {
        if (name == null) {
            throw new InvalidInitializationException(PlanType.class, "name cannot be null");
        }
        if (maxSubscriptions < 1) {
            throw new InvalidInitializationException(PlanType.class, "maxSubscriptions must be >1");
        }

        this.id = id != null ? id : UUID.randomUUID();
        this.name = name;
        this.maxSubscriptions = maxSubscriptions;
    }
    
    public PlanType(String name, int maxSubscriptions) throws InvalidInitializationException {
        this(null, name, maxSubscriptions);
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
