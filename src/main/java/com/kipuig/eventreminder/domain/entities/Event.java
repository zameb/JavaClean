package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Event {
    private final UUID id;
    private final String name;
    private final ZonedDateTime dateTime;

    public Event(UUID id, String name, ZonedDateTime dateTime) throws InvalidInitializationException {
        if (name == null) {
            throw new InvalidInitializationException(Event.class, "name cannot be null");
        }
        
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
