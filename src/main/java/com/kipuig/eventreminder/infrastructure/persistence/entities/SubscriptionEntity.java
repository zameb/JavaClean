package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Subscriptions")
public class SubscriptionEntity {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    private UUID userId;
    private UUID eventId;
    
    public SubscriptionEntity() {
    }
    
    public SubscriptionEntity(UUID id, UUID userId, UUID eventId) {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public UUID getUserId() {
        return userId;
    }
    
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    
    public UUID getEventId() {
        return eventId;
    }
    
    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }
}
