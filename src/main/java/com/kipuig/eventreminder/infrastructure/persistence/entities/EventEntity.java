package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    private UUID id;
    private String name;
    private ZonedDateTime dateTime;

    protected EventEntity() {
    }

    public EventEntity(UUID id, String name, ZonedDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }
}
