package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "Event")
public record EventEntity(
        @Id
        UUID id,
        String name,
        ZonedDateTime dateTime) {
}
