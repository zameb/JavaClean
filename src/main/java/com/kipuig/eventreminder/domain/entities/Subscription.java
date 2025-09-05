package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import java.util.UUID;

public class Subscription {

    private final UUID id;
    private final UUID userId;
    private final UUID eventId;

    public Subscription(UUID id, UUID userId, UUID eventId) throws InvalidInitializationException {
        if (userId == null) {
            throw new InvalidInitializationException(Subscription.class, "user cannot be null");
        }
        if (eventId == null) {
            throw new InvalidInitializationException(Subscription.class, "event cannot be null");
        }

        this.id = id != null ? id : UUID.randomUUID();
        this.userId = userId;
        this.eventId = eventId;
    }
    
    public Subscription(UUID userId, UUID eventId) throws InvalidInitializationException {
        this(null, userId, eventId);
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getEventId() {
        return eventId;
    }
}
