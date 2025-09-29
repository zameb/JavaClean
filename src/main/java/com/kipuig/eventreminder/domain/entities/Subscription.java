package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import java.util.UUID;

public class Subscription {

    private final UUID id;
    private final User user;
    private final Event event;

    public Subscription(UUID id, User user, Event event) throws InvalidInitializationException {
        if (user == null) {
            throw new InvalidInitializationException(Subscription.class, "user cannot be null");
        }
        if (event == null) {
            throw new InvalidInitializationException(Subscription.class, "event cannot be null");
        }

        this.id = id;
        this.user = user;
        this.event = event;
    }
    
    public Subscription(User user, Event event) throws InvalidInitializationException {
        this(null, user, event);
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }
}
