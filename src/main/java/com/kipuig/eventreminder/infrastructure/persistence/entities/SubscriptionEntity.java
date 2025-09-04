package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "subscription")
public record SubscriptionEntity(
        @Id
        UUID id,
        UUID userId,
        UUID eventId) {

}
