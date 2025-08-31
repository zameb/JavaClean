package com.kipuig.eventreminder.domain.entities;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Event {
    private final UUID id;
    private final String name;
    private final ZonedDateTime dateTime;

    public Event(UUID id, String name, ZonedDateTime dateTime) {
        this.id = id != null ? id : UUID.randomUUID();
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
