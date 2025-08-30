package com.kipuig.eventreminder.domain.entities;

import java.util.UUID;

public class Subscription {
    private final UUID id;
    private final User user;
    private final Event event;

    public Subscription(UUID id, User user, Event event) {

        if (user == null) {
            throw new IllegalArgumentException("Usuario inválido");
        }

        if (event == null) {
            throw new IllegalArgumentException("Evento inválido");
        }

        this.id = id != null ? id : UUID.randomUUID();
        this.user = user;
        this.event = event;
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
