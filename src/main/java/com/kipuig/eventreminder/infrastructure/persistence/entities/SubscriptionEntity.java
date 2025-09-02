package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "subscription")
public class SubscriptionEntity {

    @Id
    private UUID id;
    private UUID userId;
    private UUID eventId;

    protected SubscriptionEntity() {
    }

    public SubscriptionEntity(UUID id, UUID userId, UUID eventId) {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
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
